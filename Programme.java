import java.util.ArrayList;

public class Programme extends Department {
    private String programmeName;
    private String programmeId;
    private ArrayList<Module> modules;

    public Programme(String departmentName, ArrayList<Programme> programmes,
                     String programmeName, String programmeId, ArrayList<Module> modules) {
        super(departmentName, programmes);
        this.programmeName = programmeName;
        this.programmeId = programmeId;
        this.modules = modules;
    }

    public Programme(String programmeName){
        super("Default Name", new ArrayList<>());  // Provide default values
        this.programmeName = programmeName;
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

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}

