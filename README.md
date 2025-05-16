--------------------
REPORT: 
--------------------

What my app does:

My app is a simple calorie calculator that takes input from the user and calculates their BMR (Basal Metabolic Rate),
which is the number of calories your body needs to function at a basic level. 
Apart from just calculating their BMR, the user can also calculate their daily maintenance calories based on their activity levels.
The last feature the program has is a calorie goal planner. 
This feature takes the users daily maintenance calories and modifies it based on the users fitness goal, whether they want to lose, maintain, or gain weight.
This app is useful for people that simply want to know their BMR or want to know how much calories they need to be consuming in a day to lose, maintain, or gain weight.

--------------------

Algorithm 1: BMR Calculation Logic (Mifflin-St Jeor Fomula)

Calculates the users BMR (Basal Metabolic Rate) using the Mifflin-St Jeor Fomula.

Steps:
1. Get the users information from input (weight, height, age, gender)
2. If the user is male, calculate the BMR using the formula
    BMR = (10 x weight) + (6.25 x height) - (5 x age) + 5
3. If the user is female, calculate the BMR using the formula
    BMR = (10 x weight) + (6.25 x height) - (5 x age) - 161
4. Return the BMR

Big O Time Complexity: 

The Big O Time complexity for this algorithm is O(1) because it performs a fixed number of operations.

--------------------

Algorithm 2: Activity Level using Hashmap

Modifies the users BMR based on their activity levels to return their daily maintenance calories.

Steps:
1. Create Hashmap that maps activity levels to multipliers
    sedentary = 1.2
    lightly active = 1.375
    moderately active = 1.55
    active = 1.725
    very active = 1.9
2. Ask the user to input their activity level as a string using options in Hashmap
3. Check if the Hashmap contains the users input
4. If the users input is invalid the activity level is set to sedantary by default
5. Search for corresponding activity level mulltiplier from the Hashmap
6. Multiply the users BMR by the multiplier to get users maintenance calories
7. Return the maintenance calories to the user

Big O Time Complexity: 

The Big O Time complexity for this algorithm is O(1) because it performs one lookup and one multiplication.

--------------------

Algorithm 3: Fitness Goal Calorie Modifier 

Modifies the users maintenance calories based on the users fitness goal to lose, maintain, or gain weight.

Note: Used ChatGPT to give me suggestions on how I would implement this feature.

Steps:
1. Ask for user input for their fitness goal to lose, maintain, or gain weight
2. If the goal is to lose weight
    subtract 500 calories from users maintenance calories
3. If the goal is to gain weight
    add 500 calories to maintenance calories
4. If the goal is to maintain weight
    no change to maintenance calories
5. If the users input is invalid
    default to users maintenance calories
6. Return the users daily maintenance calories based on their fitness goal

Big O Time Complexity: 

The Big O Time complexity for this algorithm is O(1) because there is no loops or recursion happening in the algorithm.

--------------------

Data Structures Used: 

1. HashMap <String, Double>
    this data structure stores the activity level options as strings and their multiplier values as doubles.

2. User java class
    this data structure is used to store user data like name, age, gender, height, and weight.

3. Primitive data types 
    these data types like int, double, and string are used to store temporary user inputs.

--------------------

Design or Development Process:

1. I ran into a problem in the design process where I initially wanted to create graphics for this program, but due to time contraints, I decided to make the program a terminal based program. 
I decided to make it a terminal based program because it would be easier to test given the time I had and I was still able to meet the project requirements with a terminal based program.

2. While implementing the activity level feature I decided to choose a Hashmap instead of if or else statements. I chose to use the Hashmap data structure because it is cleaner and faster.

3. After I implemented the activity level feature I ran into a problem where the program would skip over the users input for the activity level feature, resulting in the feature not working. I fixed this by adding a scanner.nextLine() after nextDouble() to clear the buffer. This would let the user input their activity level and modify their BMR intead of the program defualting to sedantary.

--------------------