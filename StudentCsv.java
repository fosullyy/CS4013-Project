import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCsv {

    public StudentCsv() {

    }

    public void writeStudent(ArrayList<Student> student, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Student students : student) {
                writer.write(students.getName() + "," + students.getId() + "," + students.getProgramme().getProgrammeName() + ","
                        + students.getYears() + "," + students.getResults() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Student> readStudents(String filepath) {
        ArrayList<Student>students = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length >= 6) {
                    // Trim() removes any blank/white space
                    String studentName = studentData[0].trim();
                    int id = Integer.parseInt(studentData[1].trim());
                    Programme programme = new Programme(studentData[2].trim());
                    int year = Integer.parseInt(studentData[3].trim());

                    Student student = new Student(studentName, id, programme, year, new ArrayList<>(), new ArrayList<>());

                    for (int i = 4; i < studentData.length; i += 3) {
                        String moduleName = studentData[i].trim();
                        String moduleId = studentData[i + 1].trim();
                        int moduleCredits = Integer.parseInt(studentData[i + 2].trim());
                        String grade = studentData[i + 3].trim();
                        int resultYear = Integer.parseInt(studentData[i + 4].trim());
                        int resultSemester = Integer.parseInt(studentData[i + 5].trim());

                        Module module = new Module(moduleName, moduleId, moduleCredits);
                        student.addModule(module);

                        Result result = new Result(module, grade, new Semester(resultYear, resultSemester));
                        student.addResult(result);
                        students.add(student);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deleteStudent(String filepath, String idToRemove){
        Scanner scanner;
        String tempFile = "temp.csv";
        String line = "";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String name = ""; String id = ""; String programmeName = ""; String year = "";
        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            scanner = new Scanner(new File(filepath));
            //Knows a new term or data is after new line or ,
            scanner.useDelimiter("[,\n]");

            while(scanner.hasNext()){
                name = scanner.next();
                id = scanner.next();
                programmeName = scanner.next();
                year = scanner.next();
                if(!id.equals(idToRemove)){
                    pw.println(name + "," + id + "," + programmeName + "," + year);
                }
            }
            scanner.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

        }catch (Exception e){

        }

    }
}
