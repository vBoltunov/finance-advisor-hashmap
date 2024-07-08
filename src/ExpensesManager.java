import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    static HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;

        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);

        if (expensesByCategories.containsKey(category)) {
            // получите список трат в этой категории
            expensesByCategories.get(category).add(expense);
            // добавьте трату
        } else {
            ArrayList<Double> expenseList = new ArrayList<>();
            expenseList.add(expense);
            expensesByCategories.put(category, expenseList);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            System.out.println(category);
            for (double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    static double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;

        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }
}


