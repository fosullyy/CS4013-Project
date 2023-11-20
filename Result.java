import java.util.ArrayList;

public class Result {
    private Module module;
    private String grade;

    public Result(Module module, String grade) {
        this.module = module;
        this.grade = grade;
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
}

