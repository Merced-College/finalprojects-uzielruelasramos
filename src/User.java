public class User {
    
    private final String name;
    private final int age;
    private final String gender;
    private final double heightCm;
    private final double weightKg;

    public User (String name, int age, String gender, double heightCm, double weightKg) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender; 
    }

    public double getHeightCm() {
        return heightCm;
    }

    public double getWeightKg() {
        return weightKg;
    }

}
