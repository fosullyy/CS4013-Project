import java.util.ArrayList;

public class Module extends Programme {
    private String moduleName;
    private String moduleId;

    public Module(String departmentName, String departmentId, ArrayList<Programme> programmes,
                  String programmeName, String programmeId, ArrayList<Module> modules,
                  String moduleName, String moduleId) {
        super(programmeName, programmeId, modules);
        this.moduleName = moduleName;
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
