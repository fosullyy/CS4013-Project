import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentCsv {

    public DepartmentCsv() {

    }
    /**
     * Reads department data from a CSV file, creates Department objects, and associates students with their respective departments.
     *
     * @param students The list of Student objects for which departments need to be determined.
     * @param filepath The path to the CSV file containing department data.
     * @return An ArrayList containing the processed department objects with associated students.
     *
     */
    public ArrayList<Department> readAndFillDepartments(ArrayList<Student> students, String filepath) {
        ArrayList<Department> departments = new ArrayList<>();
        BufferedReader reader;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] departmentData = line.split(",");
                if (departmentData.length > 0) {
                    String departmentName = departmentData[0].trim();
                    Department department = new Department(departmentName);
                    departments.add(department);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Department department : departments) {
            for (Student student : students) {
                for (Result result : student.getResults()) {
                    if ((result.getModule().getDepartmentName().equalsIgnoreCase(department.getDepartmentName()))
                            && !department.getStudents().contains(student)) {
                        department.addStudent(student);
                    }
                }
            }
        }

        return departments;
    }
    /**
     * Finds a department by its name in a list of departments.
     *
     * @param name The name of the department to be found.
     * @param departments The list of departments to search within.
     * @return The department object with the specified name if found, otherwise null.
     */
    public Department findDepartmentByName(String name, ArrayList<Department> departments) {
        for (Department department : departments) {
            if (department.getDepartmentName().equalsIgnoreCase(name)) {
                return department;
            }
        }
        System.out.println("Department not found.");
        return null;
    }
}
