
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
    public void run() { //TODO exam board, set grade for faculty and something else im forgetting about
        boolean menuTypeQuitCon = false;
        boolean back = false;
        ModuleCsv moduleCsv = new ModuleCsv();
        StudentCsv studentCsv = new StudentCsv();
        FacultyCsv facultyCsv = new FacultyCsv();
        ResultCsv resultCsv = new ResultCsv();
        DepartmentCsv departmentCsv = new DepartmentCsv();
        ArrayList<Module> modules = moduleCsv.readModules("BookOfModulesDepartments.csv");
        ArrayList<Student> students = studentCsv.readStudents("Students.csv");
        ArrayList<Faculty> faculties = facultyCsv.readFaculty("Faculty.csv", modules);
        ArrayList<Result> results = resultCsv.readResults("Results.csv", modules, students);
        ArrayList<Department> departments = departmentCsv.readAndFillDepartments(students, "Departments.csv");
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
                    back = false;
                    System.out.println("Select what department. \"list\" for the list of departments"); //There are 37 depts. i can list them manually in interveils of 9 if needed. will be annoying but possible
                    while(!back) {
                        command = in.nextLine();
                        if (command.equals("BACK"))
                            back = true;
                        else if (command.equals("list") )
                            System.out.println("""
                                    Accounting and Finance | Architechture and Product Design | Arts Humanities and Social Sciences
                                    Biological Sciences | Business | Centre for Teaching and Learning
                                    Chemical Sciences | Computer Science & Information Systems | Coop Office UL
                                    EDUCATIONAL PSYCHOLOGY INCLUSIVE AND SPECIAL EDUCATION | Economics | Education and Health Sciences
                                    Electronic & Computer Engineering | Exchange | History
                                    Interfaculty | Irish World Academy Of Music and Dance (IWAMD) | Law
                                    Management and Marketing | Mathematics & Statistics | Nursing & Midwifery
                                    Physical Education & Sport Sciences | Physics | Politics and Public Admin
                                    President's Office UL | Primary Level Education | Psychology
                                    School of Allied Health | School of Education | School of Engineering
                                    School of English Irish and Communication | School of Medicine | School of Modern Languages and Applied Linguistics
                                    Science and Engineering | Sociology | Student Affairs UL | Work & Employment Studies
                                    """);
                        Department depart = departmentCsv.findDepartmentByName(command, departments);
                        if(departmentCsv.findDepartmentByName(command, departments) != null)
                            departmentMainMenu(depart);
                    }

                    break;
                case "3":
                    System.out.println("Log in using Faculty Name");
                    while(!back) {
                        String facID = in.nextLine().toUpperCase();

                        Faculty fact = facultyCsv.findFacultyByName(facID, faculties);
                        if (facultyCsv.findFacultyByName(facID, faculties) != null) {
                            facultyMainMenu(fact);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Option!");
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
                    System.out.println("Invalid Option!");
                    break;

            }//end department switch
        }//end department while
    }


    public void departmentExamBoardMenu(Department department){
        ModuleCsv moduleCsv = new ModuleCsv();
        StudentCsv studentCsv = new StudentCsv();
        FacultyCsv facultyCsv = new FacultyCsv();
        ResultCsv resultCsv = new ResultCsv();

        ArrayList<Module> modules = moduleCsv.readModules("BookOfModulesDepartments.csv");
        ArrayList<Student> students = studentCsv.readStudents("Students.csv");
        ArrayList<Faculty> faculties = facultyCsv.readFaculty("Faculty.csv", modules);
        ArrayList<Result> results = resultCsv.readResults("Results.csv", modules, students);

        boolean back = false;

        while(!back){
            System.out.println("\n\nDepartment Exam Board Menu\n---\n1) Hold Year Exam Board (WIP)\n2) Hold Semester Exam Board (WIP)\n9)Back");
            String command = in.nextLine();


            switch (command) {
                case "1":
                    System.out.println("Enter Year");
                    int year = in.nextInt();
                    department.holdExamBoardForYear(year);
                    break;
                case "2":
                    System.out.println("Enter Semester");
                    int semester = in.nextInt();
                    department.holdExamBoardForSemester(semester);
                    break;
                case "9":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid Option!");
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
                        String module = in.nextLine();
                        Module mod = moduleCsv.findModuleById(module, modules);
                        System.out.println("Enter Semester");
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
                    System.out.println("Invalid Option!");
                    break;

            }//end faculty switch
        }//end faculty while

    }///end fac main menu

}//end menu app