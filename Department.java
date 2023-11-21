import java.util.ArrayList;

public class Department {
    private String departmentName;
    private ArrayList<Programme> programmes;

    public Department(String departmentName, ArrayList<Programme> programmes) {
        this.departmentName = departmentName;
        this.programmes = programmes;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(ArrayList<Programme> programmes) {
        this.programmes = programmes;
    }
}

