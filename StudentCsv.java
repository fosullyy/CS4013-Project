import java.io.*;
import java.util.ArrayList;

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
            reader.readLine();
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
     * Finds a student by their ID in a list of students
     *
     * @param id The ID of student to be found
     * @param students The list of students to search within
     * @return The student object with the specified ID if found, if not found null
     */
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

