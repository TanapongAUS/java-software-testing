package engr9791;
import java.text.DecimalFormat;

public final class BmiCalculator {
    private final double weight;
    private final double height;

    /**
     * Construct a BMI Calculator
     *
     * @param weight the weight of the person in kilograms
     * @param height the height of the person in centimetres
     */
    public BmiCalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    /**
     * Get the weight of this person
     *
     * @return the weight of this person
     */
    public double weight() {
        return weight;
    }

    /**
     * Get the height of this person
     *
     * @return the height of this person
     */
    public double height() {
        return height;
    }

    /**
     * Calculate the BMI of this person based on their weight and height
     *
     * @return A String that details the BMI and a description relating to the BMI
     */
    public String calculateBMI() {
        DecimalFormat df = new DecimalFormat("#.0");
        double bmi = weight / Math.pow(height / 100, 2);
        String strRange;
        if (bmi < 18.5) {
            strRange = "Underweight";
        } else if (bmi <= 24.9) {
            strRange = "Normal";
        } else if (bmi <= 29.9) {
            strRange = "Overweight";
        } else {
            strRange = "Obese";
        }

        return "Your BMI is " + df.format(bmi) + ", which means you are in the "
                + strRange + " range.";

    }
}
