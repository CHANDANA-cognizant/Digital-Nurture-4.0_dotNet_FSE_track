public class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    // Setters (modify model)
    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentId(String id) {
        student.setId(id);
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    // Getters (read model)
    public String getStudentName() {
        return student.getName();
    }

    public String getStudentId() {
        return student.getId();
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    // Display updated model using view
    public void updateView() {
        view.displayStudentDetails(student.getId(), student.getName(), student.getGrade());
    }
}
