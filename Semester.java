public class Semester extends Year {
    private int semNumber;
    public Semester(int yearNumber, int semNumber) {
        super(yearNumber);
        this.semNumber = semNumber;
    }

    public int getSemNumber() {
        return semNumber;
    }

    public void setSemNumber(int semNumber) {
        this.semNumber = semNumber;
    }
}
