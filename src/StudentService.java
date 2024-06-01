import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService extends InputValidation {
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
        students.add(new Student("May", 19, "female", "0888888888", "003", 163.7F, 45.5F));
        students.add(new Student("Mel", 24, "male", "0987654321", "004", 175.4F, 51.2F));
        students.add(new Student("Crimson", 22, "male", "0946863105", "005", 177.8F, 62.7F));
        students.add(new Student("Julia", 21, "female", "0246813579", "006", 168.7F, 50.2F));
    }

    public void addNewStudent() {
        students.add(new Student (inputName(), inputAge(), inputGender(), inputPhoneNumber(), inputID(students), inputHeight(), inputWeight()));
        System.out.println("Done.");
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Student> getStudentsByName(String name) {
        boolean found = false;
        List<Student> nameList = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
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
            if (student.getGender().equalsIgnoreCase(gender)) {
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
            if (student.getStudentID().equalsIgnoreCase(id)) {
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

    public List<Student> getStudentsByHeight(float heightLow, float heightHigh) {
        boolean found = false;
        List<Student> heightList = new ArrayList<>();
        for (Student student : students) {
            if (student.getHeight() >= heightLow && student.getHeight() <= heightHigh) {
                heightList.add(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return heightList;
    }

    public List<Student> getStudentsByWeight(float weightLow, float weightHigh) {
        boolean found = false;
        List<Student> weightList = new ArrayList<>();
        for (Student student : students) {
            if (student.getWeight() >= weightLow && student.getWeight() <= weightHigh) {
                weightList.add(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
        return weightList;
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
                String choiceOfEdit = sc.nextLine();
                sc.nextLine();
                switch (choiceOfEdit) {
                    case "name":
                        student.setName(inputName());
                        System.out.println("Done.");
                        break;
                    case "age":
                        student.setAge(inputAge());
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
                        student.setPhoneNumber(inputPhoneNumber());
                        System.out.println("Done.");
                        break;
                    case "studentID":
                        System.out.println("Sorry, our system doesn't allow changing IDs.");
                        break;
                    case "height":
                        student.setHeight(inputHeight());
                        System.out.println("Done.");
                        break;
                    case "weight":
                        student.setWeight(inputWeight());
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

    public Student getStudentByHeightRank(int heightRank) {
        List<Float> heightList = new ArrayList<>();
        Student findStudent = null;
        for (Student student : students) {
            heightList.add(student.getHeight());
        }
        heightList.sort(Collections.reverseOrder());
        Float heightStudent = heightList.get(heightRank - 1);
        for (Student student : students) {
            if (student.getHeight() == heightStudent) {
                findStudent = student;
            }
        }
        return findStudent;
    }

    public Student getStudentByWeightRank(int weightRank) {
        List<Float> weightList = new ArrayList<>();
        Student findStudent = null;
        for (Student student : students) {
            weightList.add(student.getWeight());
        }
        weightList.sort(Collections.reverseOrder());
        Float weightStudent = weightList.get(weightRank - 1);
        for (Student student : students) {
            if (student.getWeight() == weightStudent) {
                findStudent = student;
                break;
            }
        }
        return findStudent;
    }

    public float getBMIByID(String id) {
        float bmi = 0;
        for (Student student : students) {
            if (student.getStudentID().equalsIgnoreCase(id)) {
                bmi = (float) (student.getWeight() / Math.pow((student.getHeight() / 100), 2));
            }
        }
        return bmi;
    }

    public void studentServices() {
        String id;
        System.out.println("What do you want to do today?");
        System.out.println("1. Add a new student.");
        System.out.println("2. Get student(s).");
        System.out.println("3. Delete a student.");
        System.out.println("4. Edit a student.");
        System.out.println("5. Healthcheck.");
        System.out.println("6. Exit.");
        System.out.print("Enter your choice: ");
        int choiceOfService = sc.nextInt(); //doesn't read the newline
        sc.nextLine(); //consume the remaining newline
        switch (choiceOfService) {
            case 1:
                addNewStudent();
                break;
            case 2:
                System.out.println("By what criteria do you want to retrieve student data?");
                System.out.println("1. All students.");
                System.out.println("2. Name.");
                System.out.println("3. Age.");
                System.out.println("4. Gender.");
                System.out.println("5. Phone number.");
                System.out.println("6. ID.");
                System.out.println("7. Height.");
                System.out.println("8. Weight.");
                System.out.println("9. Exit.");
                System.out.print("Enter your choice: ");
                int choiceOfGet = sc.nextInt();
                sc.nextLine();
                switch (choiceOfGet) {
                    case 1:
                        for (Student student : getAllStudents()) {
                            System.out.println(student);
                        }
                        break;
                    case 2:
                        System.out.print("Search by name: ");
                        for (Student student : getStudentsByName(sc.nextLine())) {
                            System.out.println(student);
                        }
                        break;
                    case 3:
                        System.out.print("Search by age: \nFrom: ");
                        int ageLow = sc.nextInt();
                        System.out.print("To: ");
                        int ageHigh = sc.nextInt();
                        for (Student student : getStudentsByAge(ageLow, ageHigh)) {
                            System.out.println(student);
                        }
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.print("Search by gender: ");
                        for (Student student : getStudentsByGender(sc.nextLine())) {
                            System.out.println(student);
                        }
                        break;
                    case 5:
                        System.out.print("Search by phone number: ");
                        for (Student student : getStudentsByPhoneNumber(sc.nextLine())) {
                            System.out.println(student);
                        }
                        break;
                    case 6:
                        System.out.print("Search by ID: ");
                        System.out.println(getStudentByID(sc.nextLine()));
                        break;
                    case 7:
                        System.out.print("Search by height: \nFrom: ");
                        float heightLow = sc.nextFloat();
                        System.out.print("To: ");
                        float heightHigh = sc.nextFloat();
                        for (Student student : getStudentsByHeight(heightLow, heightHigh)) {
                            System.out.println(student);
                        }
                        sc.nextLine();
                        break;
                    case 8:
                        System.out.print("Search by weight: ");
                        float weightLow = sc.nextFloat();
                        System.out.print("To: ");
                        float weightHigh = sc.nextFloat();
                        for (Student student : getStudentsByWeight(weightLow, weightHigh)) {
                            System.out.println(student);
                        }
                        sc.nextLine();
                        break;
                    case 9:
                        System.out.println("Goodbye.");
                        System.exit(90);
                    default:
                        System.out.println("Something went wrong.");
                }
                break;
            case 3:
                System.out.print("Enter your ID: ");
                id = sc.nextLine();
                deleteStudentByID(id);
                break;
            case 4:
                System.out.print("Enter your ID: ");
                id = sc.nextLine();
                editStudentByID(id);
                break;
            case 5:
                System.out.println("Which healthcheck do you want to do?");
                System.out.println("1. Get student by height rank.");
                System.out.println("2. Get student by weight rank.");
                System.out.println("3. Get BMI by ID.");
                System.out.println("4. Exit.");
                System.out.print("Enter your choice: ");
                int choiceOfHealthcheck = sc.nextInt();
                sc.nextLine();
                switch (choiceOfHealthcheck) {
                    case 1:
                        System.out.println("Currently the class has " + students.size() + " students.");
                        System.out.print("Enter height rank: ");
                        int heightRank = sc.nextInt();
                        sc.nextLine();
                        System.out.print(getStudentByHeightRank(heightRank));
                        break;
                    case 2:
                        System.out.println("Currently the class has " + students.size() + " students.");
                        System.out.print("Enter weight rank: ");
                        int weightRank = sc.nextInt();
                        sc.nextLine();
                        System.out.print(getStudentByWeightRank(weightRank));
                        break;
                    case 3:
                        System.out.println("Enter your ID: ");
                        id = sc.nextLine();
                        System.out.println("Your BMI is " + getBMIByID(id));
                        break;
                    case 4:
                        System.out.println("Goodbye.");
                        System.exit(40);
                    default:
                        System.out.println("Something went wrong.");
                }
                break;
            case 6:
                System.out.println("Goodbye.");
                System.exit(60);
            default:
                System.out.println("Something went wrong.");
        }
        System.out.println("Continue (yes/no)? ");
        System.out.print("Enter your choice: ");
        String choice = sc.nextLine();
        switch (choice) {
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
