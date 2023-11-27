import java.util.ArrayList;

/**
 * Represents a student of UL.
 */
public class Student {
    private String name;
    private int id;
    private String programmeName;
    private Year[] years;
    private int numOfYears;
    private ArrayList<Result> results;

    /**
     * Constructs Student object with its name, ID, programme, the year the student is currently in, and the student's results to date.
     * @param name The name of the student.
     * @param id The ID of the student.
     * @param programmeName The programme name of the student.
     * @param numOfYears The year the student is currently in.
     */
    public Student(String name, int id, String programmeName, int numOfYears) {
        this.name = name;
        this.id = id;
        this.programmeName = programmeName;
        this.numOfYears = numOfYears;
        this.years = new Year[numOfYears];
        this.results = new ArrayList<>();

        for (int i = 0; i < numOfYears; i++) {
            this.years[i] = new Year(i + 1);
        }
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the student.
     *
     * @return The ID of the student.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the programme of the student.
     *
     * @return The programme of the student.
     */
    public String getProgrammeName() {
        return programmeName;
    }

    /**
     * Sets the programme of the student.
     *
     * @param programme The new programme of the student.
     */
    public void setProgramme(String programmeName) {
        this.programmeName = programmeName;
    }

    /**
     * Gets the array of the years for which the student has attended, storing a year object in each slot for however many years they've attended for.
     *
     * @return The array of years of attendance of the student.
     */
    public Year[] getYears() {
        return years;
    }

    /**
     * Gets the number of years for which the student has attended.
     *
     * @return The number of years of attendance for the student.
     */
    public int getNumOfYears() {
        return numOfYears;
    }

    /**
     * Sets the number of years for which the student has attended, and changes the Years[] array as a result.
     *
     * @param numOfYears The new number of years of attendance for the student.
     */
    public void setNumOfYears(int numOfYears) {
        this.numOfYears = numOfYears;

        for (int i = 0; i < numOfYears; i++) {
            this.years[i] = new Year(i + 1);
        }
    }

    /**
     * Gets the results of the student.
     *
     * @return A list of the results of the student.
     */
    public ArrayList<Result> getResults() {
        return results;
    }

    /**
     * Adds a result to the student's list of student results.
     *
     * @param result The result to be added to the student's results.
     */
    public void addResult(Result result) {
        results.add(result);
    }

    /**
     * Allows a student to view their student transcript, which displays their results for each semester.
     *
     * @param student The student whose transcript is to be viewed.
     * @return The student transcript of the student.
     */
    public Transcript viewTranscript(Student student) {
        return new Transcript(student);
    }

    public double calculateQcaOverall() {
        if (years.length == 1) {
            return calculateQcaForYear(1);
        } else {
            double totalQCA = 0.0;
            for (Year year : years) {
                totalQCA += calculateQcaForYear(year.getYearNumber());
                totalQCA = totalQCA - calculateQcaForYear(1);
            }

            double toBeRounded = totalQCA / (years.length - 1);
            String roundedQca = String.format("%.2f", toBeRounded);
            return Double.parseDouble(roundedQca);
        }
    }

    public double calculateQcaForSemester(int semester) {
        ArrayList<String> grades = new ArrayList<>();

        for (Result result : results) {
            if (result.getSemester().getSemNumber() == semester) {
                grades.add(result.getGrade());
            }
        }

        return calculateQca(grades);
    }

    public double calculateQcaForYear(int year) {
        ArrayList<String> grades = new ArrayList<>();

        for (Result result : results) {
            if (result.getSemester().getYearNumber() == year) {
                grades.add(result.getGrade());
            }
        }

        return calculateQca(grades);
    }

    public double calculateQca(ArrayList<String> grades) {
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
