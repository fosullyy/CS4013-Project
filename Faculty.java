import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Module> modules;
    private ArrayList<Programme> programmes;
    private Department department;

    public Faculty(String name, ArrayList<Student> students, ArrayList<Module> modules, ArrayList<Programme> programmes, Department department) {
        this.name = name;
        this.students = students;
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

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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
}
