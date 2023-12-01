import java.util.ArrayList;

/**
 * Represents a UL department.
 */
public class Department {
    private String departmentName;
    private ArrayList<Student> students;

    /**
     * Constructs Department object, with its name, programmes and students.
     *
     * @param departmentName Name of the department.
     */
    public Department(String departmentName) {
        this.departmentName = departmentName;
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
        return holdExamBoard(semester, "semester");
    }


    /**
     * Holds an exam board for the year to review progression by generating the QCA for each student and whether they are required to repeat as a result.
     *
     * @param year The year for which the exam board is being held.
     * @return The exam board represented as a string.
     */
    public String holdExamBoardForYear(int year) {
        return holdExamBoard(year, "year");
    }

    /**
     * Helper method to implement logic that holds an exam board.
     * @param period The number of either the semester or year for which the exam board is being held.
     * @param periodType A string to represent the type of the period of time for which the exam board is being held, i.e. year or semester.
     * @return The exam board represented as a string.
     */
    private String holdExamBoard(int period, String periodType) {
        // Uses StringBuilder to append the exam board display as needed.
        StringBuilder board = new StringBuilder(getDepartmentName() + " exam board results for " + periodType + " " + period + ":\n");

        // Iterates through students in the department
        for (Student student : students) {
            double qca;
            if (periodType.equals("semester")) {
                qca = student.calculateQcaForSemester(period);
            } else {
                qca = student.calculateQcaForYear(period);
            }
            boolean repeatRequired = false;

            // Displays the QCA of these students.
            board.append("Student ID: ").append(student.getId()).append("\tQCA: ").append(qca);

            // Iterates through the result of each student in the department to determine whether they can progress without repeats.
            for (Result result : student.getResults()) {
                if (result.getGrade().equalsIgnoreCase("F") || result.getGrade().equalsIgnoreCase("NG")) {
                    board.append("\tStudent is required to repeat as they failed one or more modules.");
                    repeatRequired = true;  // Boolean to indicate a repeat is required.
                    break;  // No need to check further if a repeat is already required.
                }
            }

            // Check QCA after checking results
            if (!repeatRequired && qca < 2.0) {
                board.append("\tStudent is required to repeat, their QCA is insufficient as it is below 2.0");
            }

            board.append("\n");
        }

        return board.toString();
    }
}
