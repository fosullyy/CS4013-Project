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
    private ArrayList<Result>  results;

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
            this.years[i] = new Year(i + 1); // Years array is filled with year objects for how many years the student has attended, i.e. numOfYears.
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
     * @param programmeName The new programme of the student.
     */
    public void setProgrammeName(String programmeName) {
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

    /**
     * Calculates the overall QCA for a student in UL.
     *
     * @return The overall QCA for a UL student.
     */
    public double calculateQcaOverall() {
        if (years.length == 1) {
            return calculateQcaForYear(1); // If the student has only attended for a year then their overall QCA is their QCA for that year.
        } else {
            double totalQCA = 0.0;
            for (int i = 1; i < years.length; i++) {
                totalQCA += calculateQcaForYear(years[i].getYearNumber()); // Finds total QCA from the student's years of attendance, ignoring first year.
            }

            double toBeRounded = totalQCA / (years.length - 1); // If the student has attended for more than one year, first year is ignored.
            String roundedQca = String.format("%.2f", toBeRounded); // Formats the value to round it to two decimal places.
            return Double.parseDouble(roundedQca); // Returns rounded QCA.
        }
    }

    /**
     * Calculates the QCA for a semester for a UL student.
     *
     * @param semester The semester for which the QCA is being calculated.
     * @return The student's QCA for that semester.
     */
    public double calculateQcaForSemester(int semester) {
        ArrayList<String> grades = new ArrayList<>(); // Initialises ArrayList with the grades for which QCA is being calculated.

        for (Result result : results) {
            if (result.getSemester().getSemNumber() == semester) {
                grades.add(result.getGrade()); // Iterates through the results of the student for that semester and adds their grades to the ArrayList.
            }
        }

        return calculateQca(grades); // Returns requested QCA.
    }

    /**
     * Calculates the QCA for a year for a UL student.
     *
     * @param year The year for which the QCA is being calculated.
     * @return The student's QCA for that year.
     */
    public double calculateQcaForYear(int year) {
        ArrayList<String> grades = new ArrayList<>(); // Initialises ArrayList with the grades for which QCA is being calculated.

        for (Result result : results) {
            if (result.getSemester().getYearNumber() == year) {
                grades.add(result.getGrade()); // Iterates through the results of the student for that year and adds their grades to the ArrayList.
            }
        }

        return calculateQca(grades); // Returns requested QCA.
    }

    /**
     * Helper method that tallies the student's QCA total depending on the grades they got and returns their QCA.
     *
     * @param grades The grades for which QCA is being calculated.
     * @return The student's QCA based on the grades.
     */
    private double calculateQca(ArrayList<String> grades) {
        double total = 0.0; // Initialises total QCA.
        int moduleNumber = grades.size(); // Number of modules within the time period.

        for (String grade : grades) {
            // Uses a switch case loop to add the grade's corresponding QCA value to total.
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

        double qca = total / moduleNumber; // Averages the total by the number of modules.
        String roundedQca = String.format("%.2f", qca); // Formats the value to round it to two decimal places.
        return Double.parseDouble(roundedQca); // Returns the rounded QCA.
    }
}
