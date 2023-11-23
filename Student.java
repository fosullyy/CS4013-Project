import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private Programme programme;
    private Year[] years;
    private ArrayList<Result> results;
    private ArrayList<Module> modules;

    public Student(String name, int id, Programme programme, Year[] years,
                   ArrayList<Result> results, ArrayList<Module> modules) {
        this.name = name;
        this.id = id;
        this.programme = programme;
        this.years = years;
        this.results = results;
        this.modules = modules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Year[] getYears() {
        return years;
    }

    public void setYears(Year[] years) {
        this.years = years;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public Transcript viewTranscript(Student student) {
        return new Transcript(student);
    }

    public double calculateQcaOverall() {
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

    public double calculateQcaForSemester(int semester) {
        ArrayList<String> grades = new ArrayList<>();

        for (Result result : results) {
            if (result.getSemester().getSemNumber() == semester) {
                grades.add(result.getGrade());
            }
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

    public double calculateQcaForYear(int year) {
        ArrayList<String> grades = new ArrayList<>();

        for (Result result : results) {
            if (result.getSemester().getYearNumber() == year) {
                grades.add(result.getGrade());
            }
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
