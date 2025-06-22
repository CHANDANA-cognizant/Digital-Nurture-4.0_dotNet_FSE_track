public class Main {
    public static void main(String[] args) {
        // Create Model
        Student student = new Student("S101", "John Doe", "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display original details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");

        // Display updated details
        controller.updateView();
    }
}
