import java.util.ArrayList;

public class Student {
    private String studentName;
    private int id;
    private Programme programme;
    private int year;
    private ArrayList<Result> results;

    public Student(String studentName, int id, Programme programme, int year,
                   ArrayList<Result> results) {
        this.studentName = studentName;
        this.id = id;
        this.programme = programme;
        this.year = year;
        this.results = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public void addResult(Result result) {
        results.add(result);
    }
}
