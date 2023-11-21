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
        this.results = results;
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

    public Transcript viewTranscript(Student student) {
        return new Transcript(student);
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


