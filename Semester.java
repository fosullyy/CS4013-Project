public class Semester {
    private int semNumber;
    private int yearNumber;
    public Semester(int yearNumber, int semNumber) {
        this.yearNumber = yearNumber;
        this.semNumber = semNumber;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public int getSemNumber() {
        return semNumber;
    }

    public void setSemNumber(int semNumber) {
        this.semNumber = semNumber;
    }
}
