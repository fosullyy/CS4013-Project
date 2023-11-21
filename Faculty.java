import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Programme> programmes;
    private Department department;

    public Faculty(String name, ArrayList<Module> modules, ArrayList<Programme> programmes, Department department) {
        this.name = name;
        this.modules = modules;
        this.programmes = programmes;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(ArrayList<Programme> programmes) {
        this.programmes = programmes;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void submitResults(Student student, ArrayList<Result> results) {
        for (Result result : results) {
            student.addResult(result);
        }
    }

    public Transcript viewTranscript(Student student) {
        return new Transcript(student);
    }
}

