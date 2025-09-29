import java.util.Scanner;

public class HealthKiosk {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to Ashesi Health Kiosk");

        System.out.println("Enter service code (P/L/T/C): ");

        String service_code = input.nextLine().toUpperCase();

        String service = switch (service_code) {
            case "P" -> "Pharmacy";

            case "L" -> "Lab";

            case "T" -> "Triage";

            case "C" -> "Counselling";

            default -> "Invalid Service Code";
        };

        System.out.println("\nGo to: " + service + " Desk");

        //Task 2

        int health_metric_value = 0;
        
        if (service_code.equals("T")) {
        
            System.out.println("\nEnter health metric: (1 for BMI, 2 for Dosage round-up, 3 for simple trig helper): ");

            int health_metric = input.nextInt();

            if (health_metric == 1) {

                System.out.print("\nEnter weight (kg): ");

                double weight = input.nextDouble();

                System.out.print("\nEnter height (metres): ");

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
                
                health_metric_value = (int) Math.round(rounded_bmi);

                System.out.println("\nBMI " + rounded_bmi + " Category: " + category);
            }

            else if (health_metric == 2) {

                System.out.print("\nEnter required dosage (mg): ");

                double dosage = input.nextDouble();

                final double DOSAGE_LIMIT = 250;

                double numberOfTablets = Math.ceil(dosage / DOSAGE_LIMIT);

                System.out.println("\nNumber of tablets: " + (int)numberOfTablets);

                health_metric_value = (int) numberOfTablets;
            }

            else if (health_metric == 3) {
                System.out.print("\nEnter an angle (in degrees): ");

                double angle = input.nextDouble();

                double sinOfAngle = Math.round(Math.sin(Math.toRadians(angle)) * 1000) / 1000.0;

                double cosOfAngle = Math.round(Math.cos(Math.toRadians(angle)) * 1000) / 1000.0;

                System.out.println("\nSin of angle in radians: " + sinOfAngle);

                System.out.println("\nCosine of angle in radians: " + cosOfAngle);

                health_metric_value = (int) Math.round(sinOfAngle * 100);
            }
        }

        // Task 3 -> Generating Random Characters using Casting and the Random method

        
        // Generates random number from 65 to 90, which are the decimal codes for uppercase letters A to Z.
        int random_number = 65 + (int)(Math.random() * 26);

        // Uses explicit casting to convert the random integer into a character, giving a random uppercase letter
        char random_character = (char)random_number;
        
        // Generates 4 random numbers characters and concatenates them with the random uppercase letter generated
        String studentID = random_character + String.valueOf((3 + (int)(Math.random() * 7))) + String.valueOf((3 + (int)(Math.random() * 7))) + String.valueOf((3 + (int)(Math.random() * 7))) + String.valueOf((3 + (int)(Math.random() * 7)));


        if (Character.isLetter(studentID.charAt(0)) && studentID.length() == 5 && Character.isDigit((studentID.charAt(1))) && Character.isDigit((studentID.charAt(2))) && Character.isDigit((studentID.charAt(3))) && Character.isDigit((studentID.charAt(4))) ) {
            System.out.println("\nID OK");
        }
        if (!(Character.isLetter(studentID.charAt(0)))) {
            System.out.println("\nInvalid: first char must be a letter");
        }

        if (!(Character.isDigit((studentID.charAt(1))) && Character.isDigit((studentID.charAt(2))) && Character.isDigit((studentID.charAt(3))) && Character.isDigit((studentID.charAt(4))))) {
            System.out.println("\nInvalid: last 4 must be digits");
        }

        if (!(studentID.length() == 5)) {
            System.out.println("\nInvalid length");;
        }

    // Task 4 - Creating Secure Display Code

    input.nextLine();

    System.out.println("\nEnter your first name: ");

    String student_name = input.nextLine();

    char base =  Character.toUpperCase(student_name.charAt(0));

    System.out.println("\nBase code = " + base );

    char shifted_letter = (char)('A' + (base - 'A' + 2) % 26);

    System.out.println("\nShifted letter of base code = " + shifted_letter );

    String lastTwoCharacters = studentID.substring(3,5);

    System.out.println("\nLast two characters for ID (task 3):  " + lastTwoCharacters);

    String display_code = shifted_letter + lastTwoCharacters + "-" + health_metric_value;

    System.out.println("\nDisplay code:" + display_code);


// Task 5 - Printing Summary Message

String summary = "\n" + service.toUpperCase() + " | " + "ID=" + studentID + " | " + "Code=" + display_code;

System.out.println(summary);
    


    

    }

}