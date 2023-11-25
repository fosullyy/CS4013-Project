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

    /**
     * Sets the semester of the result.
     *
     * @param semester The new semester of the result.
     */
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public double calculateQCA(ArrayList<Result> results) {
        ArrayList<String> grades = new ArrayList<>();

        for (Result result : results) {
            grades.add(result.getGrade());
        }

        double total = 0.0;
        int moduleNumber = grades.size();

        for (String grade : grades) {
            switch (grade.toUpperCase()) {
                case "A1":
                    total += 4.0;
                    break;
                case "A2":
                    total += 3.6;
                    break;
                case "B1":
                    total += 3.2;
                    break;
                case "B2":
                    total += 3.0;
                    break;
                case "B3":
                    total += 2.8;
                    break;
                case "C1":
                    total += 2.6;
                    break;
                case "C2":
                    total += 2.4;
                    break;
                case "C3":
                    total += 2.0;
                    break;
                case "D1":
                    total += 1.6;
                    break;
                case "D2":
                    total += 1.2;
                    break;
                case "F", "NG":
                    total += 0.0;
                    break;
            }
        }

        double qca = total / moduleNumber;
        String roundedQca = String.format("%.2f", qca);
        return Double.parseDouble(roundedQca);
    }
}
