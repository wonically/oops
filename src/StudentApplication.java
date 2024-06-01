public class StudentApplication {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        while (true) {
            studentService.studentServices();
        }
    }
}