public class Main {
    public static void main(String[] args) {
        double currentValue = 10000.00;
        double growthRate = 0.08;
        int years = 5;

        double recursiveResult = FinancialForecaster.predictFutureValueRecursive(currentValue, growthRate, years);
        double iterativeResult = FinancialForecaster.predictFutureValueIterative(currentValue, growthRate, years);

        System.out.println("Financial Forecasting Example");
        System.out.println("Current Value: " + currentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);

        System.out.println();

        System.out.println("Predicted Future Value using Recursion: " + recursiveResult);
        System.out.println("Predicted Future Value using Iteration: " + iterativeResult);

        System.out.println();

        System.out.println("Recursive Time Complexity: O(n)");
        System.out.println("Iterative Time Complexity: O(n)");
        System.out.println("Space Complexity of Recursion: O(n) because of recursive call stack");
        System.out.println("Space Complexity of Iteration: O(1)");
    }
}
