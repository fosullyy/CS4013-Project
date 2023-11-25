import java.util.ArrayList;

/**
 * Represents a module of UL.
 */
public class Module {
    private String moduleName;
    private String moduleId;
    private int credits;

    /**
     * Constructs Module object, with its name, ID and credits.
     *
     * @param moduleName Name of the module.
     * @param moduleId ID of the module.
     * @param credits Credits of the module.
     */
    public Module(String moduleName, String moduleId, int credits) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.credits = credits;
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

    /**
     * Finds a module using just its ID, searches through an ArrayList containing all modules.
     *
     * @param moduleId ID of requested module.
     * @param bookOfModules An ArrayList containing all modules.
     * @return The module object that matches the requested ID.
     */
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
