package com.jperez.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jperez.savetravels.models.Expense;
import com.jperez.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String create(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
            return "index.jsp";
        } else {
        	expenseService.saveExpense(expense);
            return "redirect:/";
        }
	}
	
	@GetMapping("/update/{id}")
	public String showUpdate(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		if(expense != null) {	
			model.addAttribute("expense", expense);
			return "update.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@PutMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		System.out.println(expense.getId());
		if (result.hasErrors()) {
            return "update.jsp";
        } else {
        	expenseService.saveExpense(expense);
            return "redirect:/";
        }
	}
	
	@GetMapping("expenses/{id}")
	public String viewOne(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		if(expense != null) {	
			model.addAttribute("expense", expense);
			return "viewOne.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }
	
	
}