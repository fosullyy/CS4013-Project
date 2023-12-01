import java.util.ArrayList;

/**
 * Represents a student result.
 */
public class Result {
    private Module module;
    private String grade;
    private Semester semester;

    /**
     * Constructs Result object, with its associated module, grade and the semester it was obtained in.
     *
     * @param module The module of the result.
     * @param grade The grade of the result.
     * @param semester The semester the result was obtained in.
     */
    public Result(Module module, String grade, Semester semester) {
        this.module = module;
        this.grade = grade;
        this.semester = semester;
    }

    /**
     * Gets the module of the result.
     *
     * @return The module of the result.
     */
    public Module getModule() {
        return module;
    }

    /**
     * Sets the module of the result.
     *
     * @param module The new module of the result.
     */
    public void setModule(Module module) {
        this.module = module;
    }

    /**
     * Gets the grade of the result.
     *
     * @return The grade of the result.
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the result.
     *
     * @param grade The new grade of the result.
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets the semester of the result.
     *
     * @return The semester of the result.
     */
    public Semester getSemester() {
        return semester;
    }
}
