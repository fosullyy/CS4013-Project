import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvTest {
    public static void main(String[] args) {
        // Create sample students
        Student student1 = new Student("John Doe", 1, new Programme("Computer Science"), 4,
                new ArrayList<>(), new ArrayList<>());
        student1.addModule(new Module("Programming", "CS101", 4));
        student1.addModule(new Module("Database", "CS102", 3));
        student1.addResult(new Result(new Module("Programming", "CS101", 4), "A1", new Semester(1, 2)));
        student1.addResult(new Result(new Module("Database", "CS102", 3), "B2", new Semester(2, 3)));

        Student student2 = new Student("Jane Smith", 2, new Programme("Mathematics"), 3,
                new ArrayList<>(), new ArrayList<>());
        student2.addModule(new Module("Calculus", "MA101", 5));
        student2.addModule(new Module("Statistics", "MA102", 4));
        student2.addResult(new Result(new Module("Calculus", "MA101", 5), "A2", new Semester(1, 2)));
        student2.addResult(new Result(new Module("Statistics", "MA102", 4), "B1", new Semester(2, 2)));

        // Add students to a list
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(student1);
        studentsList.add(student2);

        // Specify the file path for testing
        String filePath = "C:\\Users\\conor\\Downloads\\student";

        // Call the writeStudent method
        writeStudent(studentsList, filePath);

        System.out.println("Test completed. Check the file: " + filePath);
    }

    public static void writeStudent(ArrayList<Student> students, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getId() + "," +
                        student.getProgramme().getProgrammeName() + "," +
                        student.getNumOfYears() + "," +
                        student.getResults().size() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
