import java.util.ArrayList;

public class Module {
    private String moduleName;
    private String moduleId;
    private int credits;

    public Module(String moduleName, String moduleId, int credits) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.credits = credits;
    }

    public Module(String moduleName){
        this.moduleName = moduleName;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Module findModuleById(String moduleId, ArrayList<Module> bookOfModules) {
        for (Module module : bookOfModules) {
            if (module.getModuleId().equalsIgnoreCase(moduleId)) {
                return module;
            }
        }
        System.out.println("Module not found.");
        return null;
    }
}

