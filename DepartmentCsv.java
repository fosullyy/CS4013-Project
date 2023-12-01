import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentCsv {

    public DepartmentCsv() {

    }

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
