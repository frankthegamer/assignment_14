

public class MetricConverter {

    public static double MetricConvert(int inputValue, String conversionType) {
        
     /*    System.out.println("Welcome to Metric Converter!\n");   // Old code for console app

        do {
            System.out.println("Enter a number to choose a conversion:\n");
            System.out.println("1. Millimeters to Inches");
            System.out.println("2. Meters to Kilometers");
            System.out.println("3. Feet to Miles");
            System.out.println("4. Inches to Centimeters");
            System.out.println("5. Fahrenheit to Celsius");
            System.out.println("-1 to exit");
             
            // prompt user for conversion type
          // choice = scanner.nextInt();  // equals value from MetricConvertUI.java

          //  if (choice == -1) {
                System.out.println("Exiting the program...");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue;
            }

        */
            double result = 0;

            // swapped variables to match the UI
           switch (conversionType) {
                case "Millimeters to Inches":
                    result = inputValue / 25.4;
                    System.out.println(inputValue + " mm is " + result + " in");
                    break;
                case "Meters to Kilometers":
                    result = inputValue / 1000.00000;
                    System.out.println(inputValue + " m is " + result + " km");
                    break;
                case "Feet to Miles":
                    result = inputValue / 5280.00000;
                    System.out.println(inputValue + " ft is " + result + " mi");
                    break;
                case "Inches to Centimeters":
                    result = inputValue * 2.54;
                    System.out.println(inputValue + " in is " + result + " cm");
                    break;
                case "Fahrenheit to Celsius":
                    result = (inputValue - 32) / 1.8;
                    System.out.println(inputValue + " F is " + result + " C");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number 1-5");
            }
            return result; // return the result for further processing if needed
        }
    }


