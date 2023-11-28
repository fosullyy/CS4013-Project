import java.util.Scanner;

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

        while (!menuTypeQuitCon) {
            System.out.println("1) STUDENT MENU\n2) DEPARTMENT MENU\n3) FACULTY MENU");
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "1":
                    System.out.println("Log in using Student ID **use 1 for testing purposes");
                    while(!back) {
                        command = in.nextLine().toUpperCase();
                        if(command.equals("1"))
                            studentMainMenu();
                        else if(command.equals("BACK"))
                            back = true;
                        else
                            System.out.println("Invalid ID!");
                    }

                    break;
                case "2":
                    System.out.println("Select what department **use 1 for testing purposes"); //There are 37 depts. i can list them manually in interveils of 9 if needed. will be annoying but possible
                    while(!back) {
                        command = in.nextLine().toUpperCase();
                        if (command.equals("1"))
                            departmentMainMenu();
                        else if (command.equals("BACK"))
                            back = true;
                        else
                            System.out.println("Invalid ID!");
                    }
                    break;
                case "3":
                    System.out.println("Log in using Faculty Name **use 1 for testing purposes");
                    while(!back) {
                        command = in.nextLine().toUpperCase();
                        if (command.equals("1"))
                            facultyMainMenu();
                        else if (command.equals("BACK"))
                            back = true;
                        else
                            System.out.println("Invalid ID!");
                    }
                    break;
                default:
                    System.out.println("ERROR TRAPPING");
                    break;

            }//end menu sel switch
        }//end menu sel while

    }//end run


    public void studentMainMenu() {
        boolean quitCon = false;
        while (!quitCon) {
            System.out.println("\n\nSTUDENT MENU\n 1) Grades\n9) Quit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "1":
                    studentGradeMenu();
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



    public void studentGradeMenu() {
        boolean back = false;

        while(!back){
            System.out.println("\n\nSTUDENT GRADES MENU\n---\n1) View Grades (WIP)\n2)Get Transcript (WIP)\n9)Back");
            String command = in.nextLine();


            switch (command) {
                case "1":
                    System.out.println("grades WIP");
                    break;
                case "2":
                    System.out.println("transcript WIP");
                    break;
                case "9":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR TRAPPING");
                    break;
            }

        }//end while

    }//end studentGradeMenu


    public void departmentMainMenu() {
        boolean quitCon = false;
        while (!quitCon) {
            System.out.println("\n\nDepartment MENU\n1) Exam Board\n9) Quit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "1":
                    departmentExamBoardMenu();
                    break;
                case "2":
                    System.out.println("Department 2");
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


    public void departmentExamBoardMenu(){
        boolean back = false;

        while(!back){
            System.out.println("\n\nDepartment Exam Board Menu\n---\n1) Hold Year Exam Board (WIP)\n2) Hold Semester Exam Board (WIP)\n9)Back");
            String command = in.nextLine();


            switch (command) {
                case "1":
                    System.out.println("Enter Year");
                    String year = in.nextLine();
                    System.out.println("Year " + year + " Entered");
                    break;
                case "2":
                    System.out.println("Enter Year");
                    String semYear = in.nextLine();
                    System.out.println("Year " + semYear + " Entered\n Enter Semester");
                    String semester = in.nextLine();
                    System.out.println("Semester " + semester + " Entered\nExam board for Year " + semYear + " Semester " + semester);
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

    public void facultyMainMenu(){
        boolean quitCon = false;
        while (!quitCon) {
            System.out.println("\n\nFaculty MENU\n1) Enter Grade\n2) Transcripts\n9) Quit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "1":
                    facultyResultsMenu();
                    break;
                case "2":
                    facultyTranscriptMenu();
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

    public void facultyTranscriptMenu(){
        boolean back = false;

        while(!back){
            System.out.println("\n\nFACULTY TRANSCRIPT MENU\n---\nENTER STUDENT ID");

            String command = in.nextLine();
            //looks for student id
            //im guessing ToString here with transcript
            System.out.println("STUDENT ID :" + command + "ENTERED");
            back = true;
            //i can try and error trap this but idk the actual commands to get student id atm :[
        }//end while
    }

    public void facultyResultsMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n\nFACULTY TRANSCRIPT MENU\n---\nENTER STUDENT ID");

            String id = in.nextLine();
            System.out.println("STUDENT ID : " + id + " ENTERED\nENTER MODULE");

            String module = in.nextLine();
            System.out.println("MODULE : " + module + " ENTERED\nENTER YEAR");

            String year = in.nextLine();
            System.out.println("YEAR : " + year + " ENTERED\nENTER SEMESTER");

            String semester = in.nextLine();
            System.out.println("SEMESTER : " + semester + " ENTERED\nENTER GRADE");

            String grade = in.nextLine();
            System.out.println("GRADE : " + grade + " ENTERED\nSTUDENT "+id + " GRADE FOR MODULE " + module + " IN YEAR " + year + " SEMESTER " + semester + " HAS BEEN SET TO " + grade);


            back = true;
            //holy fuck this is gonna be hell trying to make sure errors dont exist in ahhhhhhh
            // i can try and hope i can catch errors, but that might be a bit difficult :|
        }
    }
}//end menu app




