public class FinancialForecast {

    // Recursive function to predict future value
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return predictFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 10000;  // ₹10,000
        double annualGrowthRate = 0.08;  // 8% annual growth
        int years = 5;

        double futureValue = predictFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("📈 Predicted Value after %d years: ₹%.2f\n", years, futureValue);
    }
}
