/**
 * Represents a semester in the course of a student.
 */
public class Semester {
    private int semNumber;
    private int yearNumber;

    /**
     * Constructs a semester object with the number of the year it's in and the number of the semester.
     * @param semNumber The number of the semester which is determined linearly, i.e. semester 1 of year 2 would be semester 3.
     */
    public Semester(int semNumber) {
        this.yearNumber = (semNumber + 1) / 2;
        this.semNumber = semNumber;
    }

    /**
     * Gets the number of the year the semester belongs to.
     *
     * @return The number of the year the semester belongs to.
     */
    public int getYearNumber() {
        return yearNumber;
    }

    /**
     * Gets the number of semester linearly, for example semester 3 would be the second semester of year 2.
     *
     * @return The number of the semester.
     */
    public int getSemNumber() {
        return semNumber;
    }
}
