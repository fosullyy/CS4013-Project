import java.io.*;
import java.util.ArrayList;

public class ModuleCsv {

    public ModuleCsv() {
    }

    /**
     * Reads and processes module data from a csv file and returns a list of module object
     *
     * @param filepath The path to the csv file containing module data
     * @return An arraylist containing the processed module objects
     */
    public ArrayList<Module> readModules(String filepath) {
        ArrayList<Module> bookOfModules = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] moduleData = line.split(",");

                if (moduleData.length == 4) {
                    String departmentName = moduleData[0].trim();
                    String moduleId = moduleData[1].trim();
                    String moduleName = moduleData[2].trim();
                    int credits = Integer.parseInt(moduleData[3].trim());

                    Module module = new Module(departmentName, moduleName, moduleId, credits);
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

    /**
     * Writes a list of module objects to a csv file specified by the filepath
     * @param module the list of module objects to be written into a csv file
     * @param filepath The path of to the csv file where the module data will be stored
     */
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
