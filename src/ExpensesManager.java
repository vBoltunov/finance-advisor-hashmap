import java.util.ArrayList;
import java.util.Collection;
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

    // напишите метод для получения суммы всех трат
    static Double getExpensesSum() {
        double result = 0;
        for (ArrayList<Double> expenses : expensesByCategories.values()) {
            for (double expense : expenses) {
                result += expense;
            }
        }
        return result;
    }

    // напишите метод для удаления категории
    void removeCategory(String name) {
        expensesByCategories.remove(name);
    }

    // напишите метод для получения категории, где размер трат больше всего
    String getMaxCategoryName() {
        String maxCategoryName = "";
        double maxCategorySum = 0;

        for (String category : expensesByCategories.keySet()) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            double sum = 0;
            for (double expense : expenses) {
                sum += expense;
            }
            if (sum > maxCategorySum) {
                maxCategorySum = sum;
                maxCategoryName = category;
            }
        }
        return maxCategoryName;
    }
}
