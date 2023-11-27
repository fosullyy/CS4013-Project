import java.io.*;
import java.util.ArrayList;

public class CsvFile {

    public CsvFile() {
    }

    public ArrayList<Student> readStudents(String filepath) {
        ArrayList<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData.length == 4) {
                    String name = studentData[0].trim();
                    int id = Integer.parseInt(studentData[1].trim());
                    String programmeName = studentData[2].trim();
                    int year = Integer.parseInt(studentData[3].trim());

                    Student student = new Student(name, id, programmeName, year);
                    students.add(student);

                } else {
                    System.out.println("Student not found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    public ArrayList<Module> readModules(String filepath) {
        ArrayList<Module> bookOfModules = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] moduleData = line.split(",");

                if (moduleData.length == 4) {
                    Department department = new Department(moduleData[0].trim());
                    String moduleId = moduleData[1].trim();
                    String moduleName = moduleData[2].trim();
                    int credits = Integer.parseInt(moduleData[3].trim());

                    Module module = new Module(department, moduleName, moduleId, credits);
                    bookOfModules.add(module);
                } else {
                    System.out.print("No module found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bookOfModules;
    }

    public ArrayList<Faculty> readFaculty(String filepath, ArrayList<Module> bookOfModules) {
        ArrayList<Faculty> faculties = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] facultyData = line.split(",");
                if (facultyData.length == 2) {
                    String name = facultyData[0].trim();

                    String[] facultyModules = (facultyData[1].trim()).split(";");

                    ArrayList<Module> modules = new ArrayList<>();
                    for (String moduleId : facultyModules) {
                        Module module = findModuleById(moduleId, bookOfModules);
                        modules.add(module);
                    }

                    Faculty faculty = new Faculty(name, modules);
                    faculties.add(faculty);
                } else {
                    System.out.println("Faculty not found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return faculties;
    }

    public void readResults(String filepath, ArrayList<Module> bookOfModules, ArrayList<Student> students) {
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] resultsData = line.split(",");
                if (resultsData.length == 4) {
                    int id = Integer.parseInt(resultsData[0].trim());
                    Student student = findStudentById(id, students);

                    String moduleId = resultsData[1].trim();
                    String grade = resultsData[2].trim();
                    int semester = Integer.parseInt(resultsData[3].trim());

                    Result result = new Result(findModuleById(moduleId, bookOfModules), grade, new Semester(semester));

                    student.addResult(result);
                } else {
                    System.out.println("Result not found on line " + line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                writer.write(students.getName() + "," + students.getId() + "," + students.getProgrammeName() + ","
                        + students.getNumOfYears() + "," + students.getResults() + "\n");
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> allModuleIds(String filepath) {
        ArrayList<String> allModuleIds = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while ((line = reader.readLine()) != null) {
                String[] moduleData = line.split(",");

                if (moduleData.length > 0) {
                    allModuleIds.add(moduleData[0].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allModuleIds;
    }

    /**
     * Finds a module using just its ID, searches through an ArrayList containing all modules.
     *
     * @param moduleId ID of requested module.
     * @param bookOfModules An ArrayList containing all modules.
     * @return The module object that matches the requested ID.
     */
    public Module findModuleById(String moduleId, ArrayList<Module> bookOfModules) {
        for (Module module : bookOfModules) {
            if (module.getModuleId().equalsIgnoreCase(moduleId)) {
                return module;
            }
        }
        System.out.println("Module not found.");
        return null;
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
