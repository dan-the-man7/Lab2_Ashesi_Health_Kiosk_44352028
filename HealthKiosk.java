import java.util.Scanner;

public class HealthKiosk {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Ashesi Health Kiosk");

        System.out.println("Enter service code (P/L/T/C): ");

        String service_code = input.nextLine().toUpperCase();

        String service = switch (service_code) {
            case "P" -> "Pharmacy";

            case "L" -> "Lab Desk";

            case "T" -> "Triage Desk";

            case "C" -> "Counselling Desk";

            default -> "Invalid Service Code";
        };

        System.out.println("Go to: " + service);
        
        if (service_code.equals("T")) {
        
            System.out.println("Enter health metric: (1 for BMI, 2 for Dosage round-up, 3 for simple trig helper): ");

            int health_metric = input.nextInt();

            if (health_metric == 1) {

                System.out.print("Enter weight (kg): ");

                double weight = input.nextDouble();

                System.out.print("Enter height (metres): ");

                double height = input.nextDouble();

                double bmi = (weight / (height * height));

                double rounded_bmi = Math.round(bmi * 10)/10.0;

                String category = "Not known";
                
                if (bmi < 18.5) {
                    category = "Underweight";
                }
                else if (bmi >= 18.5 && bmi <= 24.9) {
                    category = "Normal";
                }
                else if (bmi >= 25.0 && bmi <= 29.9) {
                    category = "Overweight";
                }
                else if (bmi >= 30.0) {
                    category = "Obese";
                }

                System.out.println("BMI " + rounded_bmi + " Category: " + category);
            }

            if (health_metric == 2) {

                System.out.print("Enter required dosage (mg): ");

                double dosage = input.nextDouble();

                final double DOSAGE_LIMIT = 250;

                double numberOfTablets = Math.ceil(dosage / DOSAGE_LIMIT);

                System.out.println("Number of tablets: " + (int)numberOfTablets);
            }

            if (health_metric == 3) {
                System.out.print("Enter an angle (in degrees): ");

                double angle = input.nextDouble();

                double sinOfAngle = Math.round(Math.sin(Math.toRadians(angle)) * 1000) / 1000.0;

                double cosOfAngle = Math.round(Math.cos(Math.toRadians(angle)) * 1000) / 1000.0;

                System.out.println("Sin of angle in radians: " + sinOfAngle);

                System.out.println("Cosine of angle in radians: " + cosOfAngle);
            }
        }

        // Task 3 -> Generating Random Characters using Casting and the Random method

        
        // Generates random number from 65 to 90, which are the decimal codes for uppercase letters A to Z.
        int random_number = 65 + (int)(Math.random() * 26);

        // Uses explicit casting to convert the random integer into a character, giving a random uppercase letter
        char random_character = (char)random_number;
        
        // Generates 4 random numbers characters and concatenates them with the random uppercase letter generated
        String studentID = random_character + String.valueOf((3 + (int)(Math.random() * 7))) + String.valueOf((3 + (int)(Math.random() * 7))) + String.valueOf((3 + (int)(Math.random() * 7))) + String.valueOf((3 + (int)(Math.random() * 7)));

        //System.out.println(studentID);

        System.out.println(Character.isLetter(studentID.charAt(0)));


        if (Character.isLetter(studentID.charAt(0))) {
            System.out.println("ID OK");
        }
        else {
            System.out.println("Invalid: first char must be a letter");
        }

        if (Character.isDigit((studentID.charAt(0))) && Character.isDigit((studentID.charAt(1))) && Character.isDigit((studentID.charAt(2))) && Character.isDigit((studentID.charAt(3))))  {
            System.out.println("ID OK");
        }
        else {
            System.out.println("Invalid: last 4 must be digits");
        }

        if (studentID.length() == 5) {
            System.out.println("ID OK");
        }
        else {
            System.out.println("Invalid length");
        }


    

    }

}