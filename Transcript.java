import java.util.ArrayList;

public class Transcript{

    private Student student;
    private int ID;
    private String Name;
    private String moduleName;

    public Transcript(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public String toString(){
        return "Student ID: " + student.getId() + "\n" + "Student Name: " + student.getName() + "\n" + printModules(student.getModules());

    }

    public String printModules(ArrayList<Module> modules) {
        StringBuilder someModules = new StringBuilder();
        for (Module module : modules) {
            someModules.append("Module Name: " + module.getModuleName() + "\nModule ID: " + module.getModuleName() + "Module Credits: " + module.getCredits());
        }

        return someModules.toString();
    }
    public void viewModuleResults(ArrayList<Module> modules, ArrayList<Result> results) {
        for (Module module : modules) {
            System.out.println("Module: " + module.getModuleName());
            System.out.println("Results:");

            for (Result result : results) {
                if (result.getModule().equals(module)) {
                    System.out.println("  " + result.getGrade() + " - Semester " +
                            result.getSemester().getSemNumber());
                }
            }

    class Test {
        public static void main(String[] args) {
            int borderWidth = 80;
            int borderHeight = 10;


            System.out.println("+" + "-".repeat(borderWidth - 2) + "+");

            for (int i = 0; i < borderHeight; i++) {

                System.out.println("|" + " ".repeat(borderWidth - 4) + "|" + " ".repeat(1));
                {

                    System.out.println("|" + " ".repeat(borderWidth - 2) + "|");
                }
            }

            System.out.println("+" + "-".repeat(borderWidth - 2) + "+");
        }
    }

}
