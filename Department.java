import java.util.ArrayList;

public class Department {
    private String departmentName;
    private ArrayList<Programme> programmes;
    private ArrayList<Student> students;

    public Department(String departmentName, ArrayList<Programme> programmes,
                      ArrayList<Student> students) {
        this.departmentName = departmentName;
        this.programmes = programmes;
        this.students = students;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(ArrayList<Programme> programmes) {
        this.programmes = programmes;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String holdExamBoardForSemester(int semester) {
        StringBuilder board = new StringBuilder("Exam board results for semester " + semester + ":\n");

        for (Student student : students) {
            double qca = student.calculateQcaForSemester(semester);

            board.append("Student ID: ").append(student.getId()).append("\tQCA: ").append(qca);

            if (qca < 2.0) {
                board.append("\tStudent is required to repeat semester.");
            } else {
                board.append("\n");
            }
        }

        return board.toString();
    }

    public String holdExamBoardForYear(int year) {
        StringBuilder board = new StringBuilder("Exam board results for year " + year + ":\n");

        for (Student student : students) {
            double qca = student.calculateQcaForYear(year);

            board.append("Student ID: ").append(student.getId()).append("\tQCA: ").append(qca);

            if (qca < 2.0) {
                board.append("\tStudent is required to repeat year.");
            } else {
                board.append("\n");
            }
        }

        return board.toString();
    }
}
