import java.util.ArrayList;

public class Programme {
    private String programmeName;
    private String programmeId;
    private Department department;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;

    public Programme(String programmeName, String programmeId, Department department,
                     ArrayList<Module> modules, ArrayList<Student> students) {
        this.programmeName = programmeName;
        this.programmeId = programmeId;
        this.department = department;
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
