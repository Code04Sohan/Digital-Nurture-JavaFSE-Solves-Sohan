public class FinancialForcast {
    public static double predict(double currentval , double growthRate , int year){
        if (year == 0) {
            return currentval;
        }
        double nxtYrVal = currentval * (1 + growthRate);

        return predict(nxtYrVal, growthRate, year-1);
    }
}
