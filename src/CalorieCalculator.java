import java.util.HashMap; //imports the HashMap class
import java.util.Scanner; // imports the Scanner class

public class CalorieCalculator { 

    // Calculates the users BMR using Mifflin-St Jeor Equation
    // Algorithm 1
    public static double calculateBMR(User user) {
        double weight = user.getWeightKg(); 
        double height = user.getHeightCm();
        int age = user.getAge();

        // Mifflin-St Jeor Equation depending on gender
        if (user.getGender().equalsIgnoreCase("male")) {
            return 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * height - 5 * age - 161;
        }

    }

    // Main method to run program
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            //User input
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter your Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter your gender (Male/Female): ");
            String gender = scanner.nextLine();
            
            System.out.print("Enter your height in cm: ");
            double height = scanner.nextDouble();
            
            System.out.print("Enter your weight in kg: ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Clears buffer
            
            // Creates a user object
            User user = new User(name, age, gender, height, weight);
            double bmr = calculateBMR(user);
            
            // Displays the BMR result to the user (Algorithm 1)
            System.out.printf("%s, your BMR is: %.2f calories/day\n", user.getName(), bmr);
            System.out.println();

            // User activity level multiplier using hashmap (Algorithm 2)
            HashMap<String, Double> activityLevel = new HashMap<>();
            activityLevel.put("sedentary", 1.2);
            activityLevel.put("lightly active", 1.375);
            activityLevel.put("moderately active", 1.55);
            activityLevel.put("active", 1.725);
            activityLevel.put("very active", 1.9);

            // User input for activity level
            System.out.println("Enter your activity level (sedentary, lightly active, moderately active, active, very active): ");
            String activity = scanner.nextLine().toLowerCase();

            // Check if the activity level is valid based on the hashmap
            if (!activityLevel.containsKey(activity)) {
                System.out.println("Invalid activity level. Please enter a valid activity level from the options provided. Defaulting to sedentary.");
                activity = "sedentary";
            }
            
            // Displays the maintenance calories result to the user using their activity levels (Algorithm 2)
            double maintenanceCalories = bmr * activityLevel.get(activity);
            System.out.printf("%s, based on your activity level (%s), your daily maintenance calories are: %.2f\n", user.getName(), activity, maintenanceCalories);
            System.out.println();    

            // Fitness goal calorie modifier (Algorithm 3)
            System.out.println("What is your goal? (lose, maintain, or gain weight):");
            String goal = scanner.nextLine().toLowerCase();

            // Stores the calorie goal based on the user's input
            double calorieGoal;

            // Switch case to determine the calorie goal based on user input
            switch (goal) {
                case "lose":
                    calorieGoal = maintenanceCalories - 500; // Case for losing weight
                    System.out.println("To lose weight, your new daily calorie intake should be: " + calorieGoal);
                    break;
                case "gain":
                    calorieGoal = maintenanceCalories + 500; // Case for gaining weight
                    System.out.println("To gain weight, your new daily calorie intake should be: " + calorieGoal);
                    break;
                case "maintain":
                    calorieGoal = maintenanceCalories; // Case for maintaining weight
                    System.out.println("To maintain your weight, your daily calorie intake should be: " + calorieGoal);
                    break;
                default: // Default case for invalid input
                    System.out.println("Invalid goal. Please enter lose, maintain, or gain. Defaulting to maintenance calories.");
                    calorieGoal = maintenanceCalories;
                    System.out.println("To maintain your weight, your daily calorie intake should be: " + calorieGoal);
            }

        }

    }
}
