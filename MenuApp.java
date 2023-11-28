import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuApp {
    private Scanner in;

    public MenuApp() {
        in = new Scanner(System.in);
    }

    /**
     * Runs the system.
     */
    public void run() {
        boolean menuType = true;
        boolean menuTypeQuitCon = false;
        boolean back = false;
        ModuleCsv moduleCsv = new ModuleCsv();
        StudentCsv studentCsv = new StudentCsv();
        FacultyCsv facultyCsv = new FacultyCsv();
        ResultCsv resultCsv = new ResultCsv();

        ArrayList<Module> modules = moduleCsv.readModules("BookOfModulesDepartments.csv");
        ArrayList<Student> students = studentCsv.readStudents("Students.csv");
        ArrayList<Faculty> faculties = facultyCsv.readFaculty("Faculty.csv", modules);
        ArrayList<Result> results = resultCsv.readResults("Results.csv", modules, students);

        while (!menuTypeQuitCon) {
            System.out.println("1) STUDENT MENU\n2) DEPARTMENT MENU\n3) FACULTY MENU");
            String command = in.nextLine();
            back = false;
            switch (command) {
                case "1":
                    System.out.println("Log in using Student ID");
                    while(!back) {
                        int studID = in.nextInt();

                        Student test = studentCsv.findStudentById(studID, students);
                        if(studentCsv.findStudentById(studID, students) != null) {
                            studentMainMenu(test);
                        }
                    }

                    break;
                case "2":
                    System.out.println("Select what department"); //There are 37 depts. i can list them manually in interveils of 9 if needed. will be annoying but possible
                    while(!back) {
                        command = in.nextLine().toUpperCase();
                        if (command.equals("1")) {
                            Department depart = new Department("Computer Science & Information Systems");
                            departmentMainMenu(depart);
                        }
                        else if (command.equals("BACK"))
                            back = true;
                        else
                            System.out.println("Invalid ID!");
                    }
                    break;
                case "3":
                    System.out.println("Log in using Faculty Name");
                    while(!back) {
                        String facID = in.nextLine().toUpperCase();

                        Faculty test = facultyCsv.findFacultyByName(facID, faculties);
                        if (facultyCsv.findFacultyByName(facID, faculties) != null) {
                            facultyMainMenu(test);
                        }
                    }
                    break;
                default:
                    System.out.println("ERROR TRAPPING");
                    break;

            }//end menu sel switch
        }//end menu sel while

    }//end run


    public void studentMainMenu(Student studLogin) {
        boolean quitCon = false;
        while (!quitCon) {
            System.out.println("\n\nSTUDENT MENU\n 1) Transcript\n9) Quit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "1":
                    System.out.println(studLogin.viewTranscript(studLogin));
                    break;
                case "9":
                    System.out.println("STUDENT QUIT");
                    quitCon = true;
                    System.exit(0);
                default:
                    System.out.println("Invalid Option!");
                    break;

            }
        }
    }



    public void departmentMainMenu(Department department) {
        boolean quitCon = false;
        while (!quitCon) {
            System.out.println("\n\nDepartment MENU\n1) Exam Board\n9) Quit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "1":
                    departmentExamBoardMenu(department);
                    break;
                case "9":
                    System.out.println("Department QUIT");
                    quitCon = true;
                    System.exit(0);
                default:
                    System.out.println("Department ERROR TRAPPING");
                    break;

            }//end department switch
        }//end department while
    }


    public void departmentExamBoardMenu(Department department){
        boolean back = false;

        while(!back){
            System.out.println("\n\nDepartment Exam Board Menu\n---\n1) Hold Year Exam Board (WIP)\n2) Hold Semester Exam Board (WIP)\n9)Back");
            String command = in.nextLine();


            switch (command) {
                case "1":
                    System.out.println("Enter Year");
                    int year = in.nextInt();
                    System.out.println(department.holdExamBoardForYear(year)); //idk if this works. it does output, but no data :|
                    break;
                case "2":
                    System.out.println("Enter Semester");
                    int semester = in.nextInt();
                    System.out.println(department.holdExamBoardForSemester(semester)); //idk if this works. it does output, but no data :|
                    break;
                case "9":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR TRAPPING");
                    break;
            }

        }//end while

    }//end departmentGradeMenu

    public void facultyMainMenu(Faculty facID){
        StudentCsv studentCsv = new StudentCsv();
        ArrayList<Student> students = studentCsv.readStudents("Students.csv");

        ModuleCsv moduleCsv = new ModuleCsv();
        ArrayList<Module> modules = moduleCsv.readModules("BookOfModulesDepartments.csv");

        ResultCsv resultCsv = new ResultCsv();
        ArrayList<Result> results = resultCsv.readResults("Results.csv", modules, students);


        boolean quitCon = false;
        while (!quitCon) {
            System.out.println("\n\nFaculty MENU\n1) Enter Grade\n2) Transcripts\n9) Quit");
            String command = in.nextLine().toUpperCase();
            int studID = 0;
            switch (command) {
                case "1":
                    System.out.println("Enter Student ID\n");
                    studID = in.nextInt();

                    Student student = studentCsv.findStudentById(studID, students);
                    if(studentCsv.findStudentById(studID, students) != null) {
                        System.out.println("Enter Module");
                        int module = in.nextInt();
                        Module mod = new Module(, ,module,); // idk what to pass through here, nothings seems intuitive, unless we want user to type every detail.
                        System.out.println("Enter Semester");// lord knows, i hope im wrong on this ^^^
                        int semNum = in.nextInt();
                        Semester semester = new Semester(semNum);
                        System.out.println("Enter Grade (A1, A2, B2, ect)");
                        String grade = in.nextLine().toUpperCase();
                        Result result = new Result(mod,grade,semester);
                        facID.submitResult(student,result); //not tested but should work in theory
                    }
                    break;
                case "2":
                    System.out.println("Enter Student ID\n");
                    studID = in.nextInt();

                    student = studentCsv.findStudentById(studID, students);
                    if(studentCsv.findStudentById(studID, students) != null) {
                        System.out.println(student.viewTranscript(student));
                    }
                    break;
                case "9":
                    System.out.println("Faculty QUIT");
                    quitCon = true;
                    System.exit(0);
                default:
                    System.out.println("Faculty ERROR TRAPPING");
                    break;

            }//end faculty switch
        }//end faculty while

    }///end fac main menu

}//end menu app