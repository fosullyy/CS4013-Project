/**
 * Represents a module of UL.
 */
public class Module {
    private String departmentName;
    private String moduleName;
    private String moduleId;
    private int credits;

    /**
     * Constructs Module object, with its name, ID and credits.
     *
     * @param departmentName Department of the module.
     * @param moduleName Name of the module.
     * @param moduleId ID of the module.
     * @param credits Credits of the module.
     */
    public Module(String departmentName, String moduleName, String moduleId, int credits) {
        this.departmentName = departmentName;
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.credits = credits;
    }

    /**
     * Gets the department of the module.
     *
     * @return The department of the module.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Gets the name of the module.
     *
     * @return The name of the module.
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Gets the ID of the module.
     *
     * @return The ID of the module.
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * Gets the credits of the module.
     *
     * @return The credits of the module.
     */
    public int getCredits() {
        return credits;
    }
}
