import java.util.Scanner;

public class RewardsConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        var scanner = new Scanner(System.in);

        // Display a welcome message
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Please enter a cash value to convert to airline miles: ");

        // Read the user's input as a string
        var input_value = scanner.nextLine();

        // Declare a variable to store the cash value as a double
        double cashValue;
        try {
            // Try to parse the input string as a double
            cashValue = Double.parseDouble(input_value);

        } catch (NumberFormatException exception) {
            // If parsing fails, display an error message and exit the program
            System.out.println("Could not parse input value as a double, exiting");
            return;
        }

        // Display a message indicating the conversion is in progress
        System.out.println("Converting $" + input_value + " to miles");

        // Create a RewardValue object with the cashValue
        var rewardsValue = new RewardValue(cashValue);

        // Display the result, showing the miles equivalent
        System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");
    }
}

class RewardValue {
    private double cashValue;

    // Constructor that takes the cash value as a parameter
    public RewardValue(double cashValue) {
        this.cashValue = cashValue;
    }
    // Constructor that takes miles as a parameter
    public RewardValue(double miles, boolean isMiles) {
        if (isMiles) {
            this.cashValue = miles * 0.0035;
        } else {
            this.cashValue = miles;
        }
    }

    // Method to calculate the equivalent cash based on the conversion rate
    public double getCashValue() {
        return cashValue;
    }

    // Method to calculate the equivalent miles based on the conversion rate
    public double getMilesValue() {
        return cashValue / 0.0035;
    }
}


//Model answer
//
//public class RewardValue {
//    private final double cashValue;
//    public static final double MILES_TO_CASH_CONVERSION_RATE = 0.0035;
//
//    public RewardValue(double cashValue) {
//        this.cashValue = cashValue;
//    }
//
//    public RewardValue(int milesValue) {
//        this.cashValue = convertToCash(milesValue);
//    }
//
//    private static int convertToMiles(double cashValue) {
//        return (int) (cashValue / MILES_TO_CASH_CONVERSION_RATE);
//    }
//
//    private static double convertToCash(int milesValue) {
//        return milesValue * MILES_TO_CASH_CONVERSION_RATE;
//    }
//
//    public double getCashValue() {
//        return cashValue;
//    }
//
//    public int getMilesValue() {
//        return convertToMiles(this.cashValue);
//    }
//}