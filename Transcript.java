public class Transcript {
    private Student student;

    public Transcript(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public class Test {
    public static void main(String[] args) {
        int borderWidth = 80;
        int borderHeight = 10;

     
        System.out.println("+" + "-".repeat(borderWidth - 2) + "+");
        
        for (int i = 0; i < borderHeight; i++) {
         
            if (i == verticalLinePosition) {
              
                System.out.println("|" + " ".repeat(borderWidth - 4) + "|" + " ".repeat(1));
            } else {
              
                System.out.println("|" + " ".repeat(borderWidth - 2) + "|");
            }
        }

        System.out.println("+" + "-".repeat(borderWidth - 2) + "+");
    }
}

}
