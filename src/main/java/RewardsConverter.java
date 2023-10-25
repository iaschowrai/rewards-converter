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

        // Display the result, showing the cash equivalent
        System.out.println("$"+ input_value +" is worth " + rewardsValue.getCashValue() + " Rupees Cash");


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
    // Method to calculate the equivalent miles based on a simple conversion rate
    public double getCashValue() {
        // You can customize this conversion rate as needed
        double conversionRate = 84; // 1 dollar = 84 Rupees (just an example)
        return cashValue * conversionRate;
    }

    // Method to calculate the equivalent miles based on a simple conversion rate
    public double getMilesValue() {
        // You can customize this conversion rate as needed
        double conversionRate = 1.5; // 1 dollar = 1.5 miles (just an example)
        return cashValue * conversionRate;
    }
}
