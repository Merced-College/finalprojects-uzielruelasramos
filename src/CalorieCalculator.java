import java.util.Scanner;

public class CalorieCalculator {

    // Calculates the users BMR using Mifflin-St Jeor Equation
    public static double calculateBMR(User user) {
        double weight = user.getWeightKg();
        double height = user.getHeightCm();
        int age = user.getAge();

        if (user.getGender().equalsIgnoreCase("male")) {
            return 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * height - 5 * age - 161;
        }

    }

    // Main method to run program
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter your Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter your gender (Male/Female):");
            String gender = scanner.nextLine();
            
            System.out.print("Enter your height in cm: ");
            double height = scanner.nextDouble();
            
            System.out.print("Enter your weight in kg: ");
            double weight = scanner.nextDouble();
            
            User user = new User(name, age, gender, height, weight);
            double bmr = calculateBMR(user);
            
            System.out.printf("%s, your BMR is: %.2f calories/day\n", user.getName(), bmr);
        }

    }
}
