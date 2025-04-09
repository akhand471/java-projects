import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== Unit Converter =====");
            System.out.println("1. CM to Inch");
            System.out.println("2. Inch to CM");
            System.out.println("3. Celsius to Fahrenheit");
            System.out.println("4. Fahrenheit to Celsius");
            System.out.println("5. Kg to Pound");
            System.out.println("6. Pound to Kg");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value in cm: ");
                    double cm = sc.nextDouble();
                    System.out.println("Inches: " + convertCmToInch(cm));
                    break;
                case 2:
                    System.out.print("Enter value in inches: ");
                    double inch = sc.nextDouble();
                    System.out.println("Centimeters: " + convertInchToCm(inch));
                    break;
                case 3:
                    System.out.print("Enter Celsius: ");
                    double c = sc.nextDouble();
                    System.out.println("Fahrenheit: " + convertCelsiusToFahrenheit(c));
                    break;
                case 4:
                    System.out.print("Enter Fahrenheit: ");
                    double f = sc.nextDouble();
                    System.out.println("Celsius: " + convertFahrenheitToCelsius(f));
                    break;
                case 5:
                    System.out.print("Enter Kg: ");
                    double kg = sc.nextDouble();
                    System.out.println("Pounds: " + convertKgToPound(kg));
                    break;
                case 6:
                    System.out.print("Enter Pounds: ");
                    double lb = sc.nextDouble();
                    System.out.println("Kg: " + convertPoundToKg(lb));
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }

    // Conversion methods
    static double convertCmToInch(double cm) {
        return cm / 2.54;
    }

    static double convertInchToCm(double inch) {
        return inch * 2.54;
    }

    static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double convertKgToPound(double kg) {
        return kg * 2.20462;
    }

    static double convertPoundToKg(double lb) {
        return lb / 2.20462;
    }
}
