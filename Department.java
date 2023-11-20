import java.util.ArrayList;

public class Department {
    private String departmentName;
    private String departmentId;
    private ArrayList<Programme> programmes;

    public Department(String departmentName, String departmentId, ArrayList<Programme> programmes) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.programmes = programmes;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public ArrayList<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(ArrayList<Programme> programmes) {
        this.programmes = programmes;
    }
}
