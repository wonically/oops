public class Student extends Person {
    private String studentID;
    private float height;
    private float weight;

    public Student() {
    }

    public Student(String name, int age, String gender, String phoneNumber, String studentID, float height, float weight) {
        super(name, age, gender, phoneNumber);
        this.studentID = studentID;
        this.height = height;
        this.weight = weight;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %s's ID is %s. %s height is %.2f centimeters, and %s weight is %.2f kg.\n",
                this.getName(), studentID, ("male".equalsIgnoreCase(this.getGender())) ? "His" : "Her", height,
                ("male".equalsIgnoreCase(this.getGender())) ? "his" : "her", weight);
    }
}
