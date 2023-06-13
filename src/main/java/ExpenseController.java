import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final List<Expense> expenses = new ArrayList<>();

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenses;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        expenses.add(expense);
        return expense;
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable("id") int id, @RequestBody Expense updatedExpense) {
        Expense expenseToUpdate = expenses.get(id);
        expenseToUpdate.setName(updatedExpense.getName());
        expenseToUpdate.setVendor(updatedExpense.getVendor());
        expenseToUpdate.setAmountPaid(updatedExpense.getAmountPaid());
        return expenseToUpdate;
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable("id") int id) {
        expenses.remove(id);
    }
}