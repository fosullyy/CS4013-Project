import java.util.ArrayList;

/**
 * Represents a UL department.
 */
public class Department {
    private String departmentName;
    private ArrayList<Programme> programmes;
    private ArrayList<Student> students;

    /**
     * Constructs Department object, with its name, programmes and students.
     *
     * @param departmentName Name of the department.
     * @param programmes Programmes in the department.
     * @param students Students that belong to programmes in the department.
     */
    public Department(String departmentName, ArrayList<Programme> programmes,
                      ArrayList<Student> students) {
        this.departmentName = departmentName;
        this.programmes = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * Gets the department name.
     *
     * @return Name of department.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the department name.
     *
     * @param departmentName New name of department.
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets the department's list of programmes.
     *
     * @return List of department's programmes.
     */
    public ArrayList<Programme> getProgrammes() {
        return programmes;
    }

    /**
     * Sets the department's list of programmes.
     *
     * @param programmes New list of department's programmes.
     */
    public void setProgrammes(ArrayList<Programme> programmes) {
        this.programmes = programmes;
    }

    /**
     * Gets the department's list of students.
     *
     * @return The department's list of students.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Sets the department's list of students.
     *
     * @param students New list of department's students.
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * Adds a programme to the department.
     *
     * @param programme The programme to be added.
     */
    public void addProgramme(Programme programme) {
        programmes.add(programme);
    }

    /**
     * Adds a student to the department.
     *
     * @param student The student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Holds an exam board for the semester to review progression by generating the QCA for each student and whether they are required to repeat as a result.
     *
     * @param semester The semester for which the exam board is being held.
     * @return The exam board represented as a string.
     */
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

    /**
     * Holds an exam board for the year to review progression by generating the QCA for each student and whether they are required to repeat as a result.
     *
     * @param year The year for which the exam board is being held.
     * @return The exam board represented as a string.
     */
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
