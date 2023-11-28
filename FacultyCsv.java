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
                    bw.write(module.getModuleId() + ";");
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
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] facultyData = line.split(",");
                if (facultyData.length == 2) {
                    String name = facultyData[0].trim();

                    String[] facultyModules = (facultyData[1].trim()).split(";");

                    ArrayList<Module> modules = new ArrayList<>();
                    for (String moduleId : facultyModules) {
                        ModuleCsv moduleCsv = new ModuleCsv();
                        Module module = moduleCsv.findModuleById(moduleId, bookOfModules);
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

    public Faculty findFacultyByName(String name, ArrayList<Faculty> faculties) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(name)) {
                return faculty;
            }
        }
        System.out.println("Faculty member not found.");
        return null;
    }
}
