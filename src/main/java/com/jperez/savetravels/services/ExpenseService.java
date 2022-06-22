package com.jperez.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jperez.savetravels.models.Expense;
import com.jperez.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// adding the repository as a dependency
    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // returns all
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates one
    public Expense saveExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves one
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // deletes one
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }

}
