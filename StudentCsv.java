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
                writer.write(students.getName() + "," + students.getId() + "," + students.getProgrammeName() + ","
                        + students.getYears() + "," + students.getResults() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Student> readStudents(String filepath) {
        ArrayList<Student>students = new ArrayList<>();
        BufferedReader reader;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length >= 4) {
                    // Trim() removes any blank/white space
                    String studentName = studentData[0].trim();
                    int id = Integer.parseInt(studentData[1].trim());
                    String programme = studentData[2].trim();
                    int year = Integer.parseInt(studentData[3].trim());

                    Student student = new Student(studentName, id, programme, year);
                    students.add(student);

                    // The i += 5 Jumps the loop 5 positions ahead in the array so i doesnt repeat data
                       /*for (int i = 4; i < studentData.length; i += 5) {
                        //Checks if there is results data for the student before reading file
                        if(i + 4 < studentData.length){
                            String departmentName = studentData[i].trim();
                            String moduleName = studentData[i + 1].trim();
                            String moduleId = studentData[i + 2].trim();
                            int moduleCredits = Integer.parseInt(studentData[i + 3].trim());
                            String grade = studentData[i + 4].trim();
                            int resultSemester = Integer.parseInt(studentData[i + 5].trim());

                            Department department = new Department(departmentName);

                            Module module = new Module(department, moduleName, moduleId, moduleCredits);

                            Result result = new Result(module, grade, new Semester(resultSemester));
                            student.addResult(result);
                        }else{
                            System.out.println("No results found for student " + line);
                        }
                    }*/
                }else{
                    System.out.println("Student not found on line " + line);
                }
            }
            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


        public void deleteStudent(String filepath, String idToRemove){

        String tempFile = "temp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        //Not final
        String name = ""; String id = ""; String programmeName = ""; String year = ""; String moduleName = ""; String moduleId = "";
        String moduleCredits = ""; String grade = ""; String resultYear = ""; String resultSemester = "";
        try{
            Scanner scanner = new Scanner(oldFile);
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //Knows a new term or data is after new line \n or ,
            scanner.useDelimiter("[,\n]");

            while(scanner.hasNext()){
                name = scanner.next();
                id = scanner.next();
                programmeName = scanner.next();
                year = scanner.next();
                moduleName = scanner.next();
                moduleId = scanner.next();
                moduleCredits = scanner.next();
                grade = scanner.next();
                resultYear = scanner.next();
                resultSemester = scanner.next();
                if(!id.equals(idToRemove)){
                    pw.println(name + "," + id + "," + programmeName + "," + year + "," + moduleName + "," + moduleId + "," + moduleCredits + ","
                    + grade + "," + resultYear + "," + resultSemester);
                }
            }
            scanner.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        }catch (IOException e){
            e.printStackTrace();

        }


    }

    public Student findStudentById(int id, ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Student not found.");
        return null;
    }
}

