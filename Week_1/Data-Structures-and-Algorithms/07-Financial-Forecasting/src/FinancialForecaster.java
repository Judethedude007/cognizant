public class FinancialForecaster {

    public static double predictFutureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return predictFutureValueRecursive(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double predictFutureValueIterative(double currentValue, double growthRate, int years) {
        double futureValue = currentValue;

        for (int i = 1; i <= years; i++) {
            futureValue = futureValue * (1 + growthRate);
        }

        return futureValue;
    }
}
