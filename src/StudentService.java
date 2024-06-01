import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        demoDtb();
    }
//tìm theo tên, líst người > 20t, chiều cao t2 trong lớp, thêm phone cho student, in sinh viên có đầu sdt là 09, validate sdt phải 10 số, chiêu cao k qua 200
    //can nang k qua 100, ten k có số
    //in ra người có tbc chiều cao cân nặng đứng thứ nhất trong lớp
    public void demoDtb() {
        students.add(new Student("Julia", 18, "female", "0999999999", "001", 165.5F, 47.6F));
        students.add(new Student("Benson", 20, "male", "0333333333", "002", 181.6F, 70.4F));
        students.add(new Student("May", 16, "female", "0888888888", "003", 163.7F, 45.5F));
        students.add(new Student("Mel", 24, "male", "0987654321", "004", 175.4F, 51.2F));
        students.add(new Student("Crimson", 22, "male", "0946863105", "005", 177.8F, 62.7F));
        students.add(new Student("Julia", 21, "female", "0246813579", "006", 168.7F, 50.2F));
    }

    public void addNewStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student age: ");
        int age = sc.nextInt();

        System.out.print("Enter student gender: ");
        String gender;
        boolean validGender = false;
        do {
            gender = sc.nextLine();
            if (gender.equals("male") || gender.equals("female")) {
                validGender = true;
                break;
            }
        } while (!validGender);

        System.out.print("Enter student phone number: ");
        String phoneNumber;
        boolean validPhoneNumber;
        do {
            phoneNumber = sc.nextLine();
            validPhoneNumber = phoneNumber.matches("0[389]\\d{8}");
        } while (!validPhoneNumber);

        System.out.print("Enter student ID: ");
        String id;
        boolean duplicateID = false;
        do {
            id = sc.nextLine();
            for (Student student : students) {
                if (student.getStudentID().equals(id)) {
                    System.out.println("Already exists.");
                    duplicateID = true;
                    break;
                }
            }
        } while (duplicateID);

        System.out.print("Enter student height: ");
        float height = sc.nextFloat();

        System.out.print("Enter student weight: ");
        float weight = sc.nextFloat();

        students.add(new Student(name, age, gender, phoneNumber, id, height, weight));
        System.out.println("Done.");
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> getStudentsByName(String name) {
        boolean found = false;
        List<Student> nameList = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                nameList.add(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return nameList;
    }

    public List<Student> getStudentsByAge(int ageLow, int ageHigh) {
        boolean found = false;
        List<Student> ageList = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() >= ageLow && student.getAge() <= ageHigh) {
                ageList.add(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return ageList;
    }

    public List<Student> getStudentsByGender(String gender) {
        boolean found = false;
        List<Student> genderList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                genderList.add(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return genderList;
    }

    public List<Student> getStudentsByPhoneNumber(String phoneNumber) {
        boolean found = false;
        List<Student> phoneNumberList = new ArrayList<>();
        for (Student student : students) {
            if (student.getPhoneNumber().matches(phoneNumber + "\\d*")) {
                phoneNumberList.add(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return phoneNumberList;
    }

    public Student getStudentByID(String id) {
        boolean found = false;
        Student idStudent = new Student();
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                idStudent = student;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return idStudent;
    }

    public void getStudentsByHeight(float heightLow, float heightHigh) {
        boolean found = false;
        List<Student> heightList = new ArrayList<>();
        for (Student student : students) {
            if (student.getHeight() >= heightLow && student.getHeight() <= heightHigh) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void getStudentsByWeight(float weightLow, float weightHigh) {
        boolean found = false;
        for (Student student : students) {
            if (student.getWeight() >= weightLow && student.getWeight() <= weightHigh) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudentByID(String id) {
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                System.out.println("Deleted student " + student.getStudentID() + ".");
                students.remove(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void editStudentByID(String id) {
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                System.out.print("What do you want to edit (name, age, gender, phone number, student ID, height, weight)? ");
                String edited = sc.nextLine();
                switch (edited) {
                    case "name":
                        System.out.print("Enter new name: ");
                        String name = sc.nextLine();
                        student.setName(name);
                        System.out.println("Done.");
                        break;
                    case "age":
                        System.out.println("Enter new age: ");
                        int age = sc.nextInt();
                        student.setAge(age);
                        System.out.println("Done.");
                        break;
                    case "gender":
                        if (student.getGender().equals("male")) {
                            student.setGender("female");
                        } else {
                            student.setGender("male");
                        }
                        System.out.println("Done.");
                        break;
                    case "phone number":
                        System.out.print("Enter new phone number: ");
                        String phoneNumber;
                        boolean validPhoneNumber;
                        do {
                            phoneNumber = sc.nextLine();
                            validPhoneNumber = phoneNumber.matches("0[389]\\d{8}");
                        } while (!validPhoneNumber);
                        break;
                    case "studentID":
                        System.out.println("Sorry, our system doesn't allow changing IDs.");
                        break;
                    case "height":
                        System.out.print("Enter new height: ");
                        float height = sc.nextFloat();
                        student.setHeight(height);
                        System.out.println("Done.");
                        break;
                    case "weight":
                        System.out.print("Enter new weight: ");
                        float weight = sc.nextFloat();
                        student.setWeight(weight);
                        System.out.println("Done.");
                        break;
                    default:
                        System.out.println("Something went wrong.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void studentServices() {
        String id;
        System.out.println("What do you want to do today?");
        System.out.println("1. Add new student.");
        System.out.println("2. Get all students.");
        System.out.println("3. Get students by name.");
        System.out.println("3. Get student by ID.");
        System.out.println("4. Delete student by ID.");
        System.out.println("5. Edit student by ID.");
        System.out.println("6. Exit");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                addNewStudent();
                break;
            case "2":
                getAllStudents();
                break;
            case "3":
                System.out.print("Enter your ID: ");
                id = sc.nextLine();
                getStudentByID(id);
                break;
            case "4":
                System.out.print("Enter your ID: ");
                id = sc.nextLine();
                deleteStudentByID(id);
                break;
            case "5":
                System.out.print("Enter your ID: ");
                id = sc.nextLine();
                editStudentByID(id);
                break;
            case "6":
                System.out.println("Goodbye.");
                System.exit(0);
            default:
                System.out.println("Something went wrong.");
        }
        System.out.println("Continue (yes/no)? ");
        String ans = sc.nextLine();
        switch (ans) {
            case "yes":
                System.out.println("Great! Let's continue!");
                break;
            case "no":
                System.out.println("Goodbye.");
                System.exit(0);
            default:
                System.out.println("I don't understand what you mean, but let's continue.");
        }
    }
}
