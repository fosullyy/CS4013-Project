import java.io.*;
import java.util.ArrayList;

public class CsvFile {


    public CsvFile() {
    }


    public Result readStudents(String filepath) {
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if(studentData.length >= 5){
                    // Trim() removes any blank space
                    String studentName = studentData[0].trim();
                    int id = Integer.parseInt(studentData[1].trim());
                    Programme programme = new Programme(studentData[2].trim());
                    int year = Integer.parseInt(studentData[3].trim());

                    //Parsing/Turning Results to String values
                    ArrayList<Result> results = new ArrayList<>();
                    String[] resultsString = studentData[4].split(";");
                    for(String resultString : resultsString){
                        String[] resultData = resultString.trim().split(",");
                        if(resultData.length == 3){
                            String moduleName = resultData[0].trim();
                            String grade = resultData[1].trim();
                            int semester = Integer.parseInt(resultData[2].trim());
                            //Instance of module class as module object in Result constructor
                            Module module = new Module(moduleName);
                            return new Result(module, grade, semester);

                        }else{
                            // Return error
                            System.out.println("Invalid resultString format: " + resultString);
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return null;
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

    public void writeStudent(ArrayList<Student>student, String filepath){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for(Student students : student){
                writer.write(students.getStudentName() + "," + students.getId() + "," + students.getProgramme() + ","
                + students.getYear() + "," + students.getResults() + "\n");
            writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

