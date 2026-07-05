package financial_forecasting;

public class Main {

    public static void main(String[] args) {

        double currentAmount = 10000;
        double growthRate = 0.10;
        int years = 5;

        Financial_forcast obj = new Financial_forcast();

        double futureValue = obj.forecast(currentAmount, growthRate, years);

        System.out.println("Current Amount : " + currentAmount);
        System.out.println("Growth Rate    : " + (growthRate * 100) + "%");
        System.out.println("Years          : " + years);
        System.out.printf("Future Value   : %.2f%n", futureValue);
    }
}