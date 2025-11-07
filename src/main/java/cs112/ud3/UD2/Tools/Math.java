package cs112.ud3.UD2.Tools;

/**
 * A class used to store commonly used math operations in this program.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 */
public class Math {

    public static double roundDouble(double number, int decimalPlace) {

        double roundNearest = 1 / decimalPlace,
                remainder = number % roundNearest,
                truncated = number - remainder;

        return remainder >= 0.5 * roundNearest ? truncated + roundNearest : truncated;
    }

}
