import java.io.*;
import java.util.ArrayList;

public class CsvFile {


    public CsvFile() {
    }

    public void writeModules(ArrayList<Module> module, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Module module1 : module) {
                writer.write(module1.getModuleName() + "," + module1.getModuleId() + "," + module1.getCredits() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Module> readModules(String filepath) {
        ArrayList<Module> bookOfModules = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] moduleData = line.split(",");

                if (moduleData.length == 3) {
                    String moduleId = moduleData[0].trim();
                    String moduleName = moduleData[1].trim();
                    int credits = Integer.parseInt(moduleData[2].trim());

                    Module module = new Module(moduleName, moduleId, credits);
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
}

