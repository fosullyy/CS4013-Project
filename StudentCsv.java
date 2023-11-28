import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCsv {

    public StudentCsv() {

    }

    /**
     * Writes a list of student objects to a csv file
     *
     * @param student Student object to be written to file
     * @param filepath The path of the csv file where the student information will be stored
     */
    public void writeStudent(ArrayList<Student> student, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Student students : student) {
                writer.write(students.getName() + "," + students.getId() + "," + students.getProgrammeName() + ","
                        + students.getNumOfYears() + "," + students.getResults() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads student information and returns an arraylist of student objects
     *
     * @param filepath A csv file containing students
     * @return An arraylist of student objects
     */
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

                }else{
                    System.out.println("Student not found on line " + line);
                }
            }
            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes a student information from csv file based on provided ID
     *
     * @param filepath  The path of the csv file storing student information
     * @param idToRemove The ID of the student whose information is being deleted
     */
    public void deleteStudent(String filepath, String idToRemove){

        String tempFile = "temp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        //Not final
        String name = ""; String id = ""; String programmeName = ""; String year = ""; String moduleName = ""; String moduleId = "";
        String moduleCredits = ""; String grade = ""; String resultYear = ""; String resultSemester = "";
        try{
            Scanner scanner = new Scanner(oldFile);
            //Creates temp.csv file if it doesn't already exist
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
                /*moduleName = scanner.next();
                moduleId = scanner.next();
                moduleCredits = scanner.next();
                grade = scanner.next();
                resultYear = scanner.next();
                resultSemester = scanner.next();*/
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

    public void addStudentsToDepartments(ArrayList<Student> students) {
        for (Student student : students) {
            for (Result result : student.getResults()) {
                Module module = result.getModule();
                if (module != null) {
                    Department department = module.getDepartment();
                    if (department != null) {
                        department.addStudent(student);
                    }
                }
            }
        }
    }
}

