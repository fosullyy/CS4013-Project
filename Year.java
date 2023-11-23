public class Year {
    private int yearNumber;
    private Semester semester1;
    private Semester semester2;

    public Year(int yearNumber) {
        this.yearNumber = yearNumber;
        this.semester1 = new Semester(yearNumber, (2 * yearNumber) - 1);
        this.semester2 = new Semester(yearNumber, (2 * yearNumber));
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public Semester getSemester1() {
        return semester1;
    }

    public void setSemester1(Semester semester1) {
        this.semester1 = semester1;
    }

    public Semester getSemester2() {
        return semester2;
    }

    public void setSemester2(Semester semester2) {
        this.semester2 = semester2;
    }
}
