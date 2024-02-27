package Insurance;

import java.util.HashMap;

public class InsuranceRater {

    private static final double THEFT_COVER_RATE = 20;
    private static final double GLASS_COVER_RATE = 50;
    private static final double LUGGAGE_COVER_RATE = 20;
    private static final double MINIMUM_PREMIUM = 500; // Task 2
    private static final double CITY_FACTOR_IF_NOT_SELECTED = 3;
    private static final double CITY_AVERAGE_MULTIPLIER = 1.35;

    private HashMap<String, Double> cityFactors;

    public InsuranceRater(HashMap<String, Double> cityFactors) {

        this.cityFactors = cityFactors;
    }

    public static void main(String[] args) {
        HashMap<String, Double> cityFactors = new HashMap<>();

        cityFactors.put("cityA", 1.2);
        cityFactors.put("cityB", 1.5);

        InsuranceRater insuranceRater = new InsuranceRater(cityFactors);
        double contentSumInsured = 40000;
        boolean theftCover = true;
        boolean glassCover = false;
        boolean luggageCover = true;
        String city = "CityA";
        double premium = insuranceRater.calculatePremium(contentSumInsured, theftCover, glassCover, luggageCover, city);
        String exportMessage = insuranceRater.generateExportMessage(premium, city);

        System.out.println("Premium: " + premium);
        System.out.println("Export Message: " + exportMessage);
    }

    private double calculatePremium(double contentSumInsured, boolean theftCover, boolean glassCover,
            boolean luggageCover, String city) {

        double optionalCoverSum = 0;
        if (theftCover) {
            optionalCoverSum += THEFT_COVER_RATE;
        }
        if (luggageCover) {
            optionalCoverSum += LUGGAGE_COVER_RATE;
        }
        if (glassCover) {
            optionalCoverSum += GLASS_COVER_RATE;
        }

        // Task 4(CITY_FACTOR_IF_NOT_SELECTED = 3)
        double cityFactor = cityFactors.containsKey(city) ? cityFactors.get(city) : CITY_FACTOR_IF_NOT_SELECTED;
        // Task 1
        double premium = (contentSumInsured * 0.02 * optionalCoverSum / 100) * cityFactor;
        return Math.max(premium, MINIMUM_PREMIUM);
    }

    // Task 3
    private String generateExportMessage(double premium, String city) {
        double cityAverage = premium * CITY_AVERAGE_MULTIPLIER;
        return "Your Annual Premium is " + premium + ". This is in the lower range in " + city + ". Average in " + city
                + " is " + cityAverage + ".";
    }
}
