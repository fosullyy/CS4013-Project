import java.util.ArrayList;

public class Result {
    private Module module;
    private String grade;
    private int semester;

    public Result(Module module, String grade, int semester) {
        this.module = module;
        this.grade = grade;
        this.semester = semester;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
