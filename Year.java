/**
 * Represents a year of attendance for a student.
 */
public class Year {
    private int yearNumber;
    private Semester semester1;
    private Semester semester2;

    /**
     * Constructs a year object with its number in accordance with what year the student is in.
     * Also has two semesters which are created to represent semesters linearly across a course, e.g. year 2 semester 1 is created as semester 3.
     * @param yearNumber The year that the student who's attending is in.
     */
    public Year(int yearNumber) {
        this.yearNumber = yearNumber;
        this.semester1 = new Semester((2 * yearNumber) - 1);
        this.semester2 = new Semester((2 * yearNumber));
    }

    /**
     * Gets the number of year the student is in.
     *
     * @return The number of year the student is in.
     */
    public int getYearNumber() {
        return yearNumber;
    }

    /**
     * Gets the number of first semester of the year the student is in.
     *
     * @return The number of first semester of the year the student is in.
     */
    public Semester getSemester1() {
        return semester1;
    }

    /**
     * Gets the number of second semester of the year the student is in.
     *
     * @return The number of second semester of the year the student is in.
     */
    public Semester getSemester2() {
        return semester2;
    }
}
