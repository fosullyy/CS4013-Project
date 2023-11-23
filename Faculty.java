import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Module> modules;

    public Faculty(String name, ArrayList<Module> modules) {
        this.name = name;
        this.modules = new ArrayList<>();
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

    public void addModule(Module module) {
        modules.add(module);
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
