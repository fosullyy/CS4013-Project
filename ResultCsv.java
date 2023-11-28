import java.io.*;
import java.util.ArrayList;

public class ResultCsv {
    public ResultCsv(){}

    public void readResults(String filepath, ArrayList<Module> bookOfModules, ArrayList<Student> students) {
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] resultsData = line.split(",");
                if (resultsData.length == 4) {
                    int id = Integer.parseInt(resultsData[0].trim());
                    StudentCsv studentCsv = new StudentCsv();
                    Student student = studentCsv.findStudentById(id, students);

                    String moduleId = resultsData[1].trim();
                    String grade = resultsData[2].trim();
                    int semester = Integer.parseInt(resultsData[3].trim());
                    ModuleCsv moduleCsv = new ModuleCsv();
                    Result result = new Result(moduleCsv.findModuleById(moduleId, bookOfModules), grade, new Semester(semester));

                    student.addResult(result);
                } else {
                    System.out.println("Result not found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeResult(Student student, Result result, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(student.getId() + "," + result.getModule().getModuleId() + "," +
                    result.getGrade() + "," + result.getSemester().getSemNumber() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
