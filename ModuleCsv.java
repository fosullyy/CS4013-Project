import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModuleCsv {

    public ModuleCsv() {
    }


    public ArrayList<Module> readModules(String filepath) {
        ArrayList<Module> bookOfModules = new ArrayList<>();
        Set<String> departments = new HashSet<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] moduleData = line.split(",");

                if (moduleData.length == 4) {
                    String departmentName = moduleData[0].trim();

                    // Check if the department already exists
                    Department department;
                    if (departments.contains(departmentName)) {
                        department = new Department(departmentName);
                    } else {
                        department = new Department(departmentName);
                        departments.add(departmentName);
                    }
                    String moduleId = moduleData[1].trim();
                    String moduleName = moduleData[2].trim();
                    int credits = Integer.parseInt(moduleData[3].trim());

                    Module module = new Module(department, moduleName, moduleId, credits);
                    bookOfModules.add(module);
                } else {
                    System.out.print("No module found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bookOfModules;
    }


    public void writeModules(ArrayList<Module> module, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Module module1 : module) {
                writer.write(module1.getModuleName() + "," + module1.getModuleId() + "," + module1.getCredits() + "\n");
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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