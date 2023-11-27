import java.util.ArrayList;

/**
 * Represents a faculty member.
 */
public class Faculty {
    private String name;
    private ArrayList<Module> modules;

    /**
     * Constructs Faculty object with its name, department and modules.
     *
     * @param name Name of the faculty member.
     * @param modules The modules the faculty member teaches in.
     */
    public Faculty(String name, ArrayList<Module> modules) {
        this.name = name;
        this.modules = modules;
    }

    /**
     * Gets name of the faculty member.
     *
     * @return The name of the faculty member.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the faculty member.
     *
     * @param name The new name of the faculty member.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets list of modules of the faculty member.
     *
     * @return The list of modules of the faculty member.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }

    /**
     * Sets the list of modules of the faculty member.
     *
     * @param modules The new list of modules of the faculty member.
     */
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    /**
     * Adds a new module to the faculty member's module list.
     *
     * @param module The module to be added.
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    /**
     * Submits a result for a student.
     *
     * @param student The student whose result is being submitted.
     * @param result The result to be submitted.
     */
    public void submitResult(Student student, Result result) {
        student.addResult(result);
    }

    /**
     * Views the transcript of a student.
     *
     * @param student Student whose transcript is to be viewed.
     * @return The student's transcript.
     */
    public Transcript viewTranscript(Student student) {
        return new Transcript(student);
    }
}
