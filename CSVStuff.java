import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVStuff {
    public void writeStudents(ArrayList<Student> students, String filepath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write("Student Name,Student ID,Student Programme,Year of Study\n");

            for (Student student : students) {
                writer.write(student.getStudentName() + "," + student.getId() + "," +
                        student.getProgramme().getProgrammeId() + "," + student.getYear() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeResults(ArrayList<Result> results, String filepath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write("Student Name,Student ID,Module,Result\n");

            for (Result result : results) {
                writer.write(result.getStudent().getStudentName() + "," + result.getStudent().getId() + "," +
                        result.getModule() + "," + result.getGrade() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
