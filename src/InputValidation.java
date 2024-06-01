import java.util.List;
import java.util.Scanner;

public class InputValidation {
    Scanner sc = new Scanner(System.in);

    public String inputName() {
        System.out.print("Enter student name: ");
        String name;
        boolean validName = false;
        do {
            name = sc.nextLine();
            if (name.matches("^([a-zA-Z]+\\s?)+")) {
                validName = true;
            } else {
                System.out.print("Invalid name. Enter again: ");
            }
        } while (!validName);
        return name.trim();
    }

    public int inputAge() {
        System.out.print("Enter student age (18 to 30 years): ");
        int age;
        boolean validAge = false;
        do {
            age = sc.nextInt();
            if (age >= 18 && age <= 30) {
                validAge = true;
            } else {
                System.out.print("Invalid age. Enter again: ");
            }
        } while (!validAge);
        return age;
    }

    public String inputGender() {
        System.out.print("Enter student gender: ");
        String gender = sc.nextLine().toLowerCase();
        boolean validGender = false;
        do {
            gender = sc.nextLine().toLowerCase();
            if (gender.equals("male") || gender.equals("female")) {
                validGender = true;
            } else {
                System.out.print("Invalid gender. Enter again: ");
            }
        } while (!validGender);
        return gender;
    }

    public String inputPhoneNumber() {
        System.out.print("Enter student phone number: ");
        String phoneNumber;
        boolean validPhoneNumber = false;
        do {
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches("0[389]\\d{8}")) {
                validPhoneNumber = true;
            } else {
                System.out.print("Invalid phone number. Enter again: ");
            }
        } while (!validPhoneNumber);
        return phoneNumber;
    }

    public String inputID(List<Student> students) {
        System.out.print("Enter student ID: ");
        String id;
        boolean duplicateID;
        do {
            duplicateID = false;
            id = sc.nextLine().toUpperCase();
            for (Student student : students) {
                if (student.getStudentID().equals(id)) {
                    System.out.print("Already exists. Enter again: ");
                    duplicateID = true;
                    break;
                }
            }
        } while (duplicateID);
        return id;
    }

    public float inputHeight() {
        System.out.print("Enter student height (100 to 200 centimeters): ");
        float height;
        boolean validHeight = false;
        do {
            height = sc.nextFloat();
            if (height >= 100 && height <= 200) {
                validHeight = true;
            } else {
                System.out.print("Invalid height. Enter again: ");
            }
        } while (!validHeight);
        return height;
    }

    public float inputWeight() {
        System.out.print("Enter student weight (30 to 100 kilograms): ");
        float weight;
        boolean validWeight = false;
        do {
            weight = sc.nextFloat();
            if (weight >= 30 && weight <= 100) {
                validWeight = true;
            } else {
                System.out.print("Invalid weight. Enter again: ");
            }
        } while (!validWeight);
        return weight;
    }
}
