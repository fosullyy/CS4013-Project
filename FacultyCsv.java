import java.io.*;
import java.util.ArrayList;

public class FacultyCsv {

    public FacultyCsv(){

    }

    public void writeFaculty(ArrayList<Faculty>faculty, String filepath){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            for(Faculty faculties : faculty){
                bw.write(faculties.getName() + "," );

                //Go through the modules array and split the info
                for(Module module : faculties.getModules()){
                    bw.write(module.getDepartment().getDepartmentName() + "," + module.getModuleName() + "," + module.getModuleId() + "," + module.getCredits() + "\n");
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Faculty> readFaculty(String filepath, ArrayList<Module> bookOfModules) {
        ArrayList<Faculty> faculties = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] facultyData = line.split(",");
                if (facultyData.length == 2) {
                    String name = facultyData[0].trim();

                    String[] facultyModules = (facultyData[1].trim()).split(";");

                    ArrayList<Module> modules = new ArrayList<>();
                    for (String moduleId : facultyModules) {
                        CsvFile csvFile = new CsvFile();
                        Module module = csvFile.findModuleById(moduleId, bookOfModules);
                        modules.add(module);
                    }

                    Faculty faculty = new Faculty(name, modules);
                    faculties.add(faculty);
                } else {
                    System.out.println("Faculty not found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return faculties;
    }
}
