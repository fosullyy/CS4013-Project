import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Programme> programmes;

    public Faculty(String name, ArrayList<Module> modules, ArrayList<Programme> programmes) {
        this.name = name;
        this.modules = modules;
        this.programmes = programmes;
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

    public void submitResults(Student student, ArrayList<Result> results) {
        for (Result result : results) {
            student.addResult(result);
        }
    }

    public Transcript viewTranscript(Student student) {
        return new Transcript(student);
    }
}
