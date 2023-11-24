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
        boolean quitCon = false;


        while (!menuTypeQuitCon) {
            System.out.println("1) STUDENT MENU\n2) STAFF MENU");
            String command = in.nextLine();
            switch (command) {
                case "1":
                    menuType = true;
                    menuTypeQuitCon = true;
                    break;
                case "2":
                    menuType = false;
                    menuTypeQuitCon = true;
                    break;
                default:
                    System.out.println("ERROR TRAPPING");
                    break;

            }//end menu sel switch
        }//end menu sel while


        if (menuType) {

            while (!quitCon) {
                System.out.println("\n\nSTUDENT MENU\n 1) Grades\n234 FOR TESTING : 9 TO QUIT");
                String command = in.nextLine().toUpperCase();

                switch (command) {
                    case "1":
                        studentGradeMenu();
                        break;
                    case "2":
                        System.out.println("STUDENT 2");
                        break;
                    case "3":
                        System.out.println("STUDENT 3");
                        break;
                    case "4":
                        System.out.println("STUDENT 4");
                        break;
                    case "9":
                        System.out.println("STUDENT QUIT");
                        quitCon = true;
                        System.exit(0);
                    default:
                        System.out.println("STUDENT ERROR TRAPPING");
                        break;

                }

            }//end student while
        } else {
            while (!quitCon) {
                System.out.println("\n\nSTAFF MENU\n1) Grades\n234 FOR TESTING : Q TO QUIT");
                String command = in.nextLine().toUpperCase();

                switch (command) {
                    case "A":
                        staffGradeMenu();
                        break;
                    case "B":
                        System.out.println("STAFF 2");
                        break;
                    case "C":
                        System.out.println("STAFF 3");
                        break;
                    case "D":
                        System.out.println("STAFF 4");
                        break;
                    case "Q":
                        System.out.println("STAFF QUIT");
                        quitCon = true;
                        System.exit(0);
                    default:
                        System.out.println("STAFF ERROR TRAPPING");
                        break;

                }//end staff switch
            }//end staff while


        }//end else

    }//end run


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

    public void staffGradeMenu(){
        boolean back = false;

        while(!back){
            System.out.println("\n\nSTAFF GRADES MENU\n---\n1) View Grades (WIP)\n2)Assign/Re-Assign Grades (WIP)\n9)Back");
            String command = in.nextLine();


            switch (command) {
                case "1":
                    System.out.println("grades WIP");
                    break;
                case "2":
                    System.out.println("assign grades WIP");
                    break;
                case "9":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR TRAPPING");
                    break;
            }

        }//end while

    }//end staffGradeMenu

}//end menu app




