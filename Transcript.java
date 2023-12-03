/**
 * Represents transcript for a given student.
 */
public class Transcript {

    private Student student;


    /**
     * Constructs Transcript object which takes the student for whom the transcript is being generated.
     *
     * @param student The student who the transcript belongs to.
     */
    public Transcript(Student student) {
        this.student = student;
    }

    /**
     * Gets the student who the transcript belongs to.
     *
     * @return The student who the transcript belongs to.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * toString method which returns the student's transcript in a legible form.
     *
     * @return The student's transcript represented as a string.
     */
    @Override
    public String toString() {
        StringBuilder transcript = new StringBuilder();
        transcript.append(student.getName()).append("'s student transcript\nID: ").append(student.getId()).append("\n");
        transcript.append("Programme: ").append(student.getProgrammeName()).append("\n");
        // Loop through each year in student's academic history
        for (int i = 0; i < student.getNumOfYears(); i++) {
            Year year = student.getYears()[i];
            transcript.append("\nYear ").append(year.getYearNumber()).append(": \n");
            // Loop through each semester in a year
            for (int j = 1; j <= 2; j++) {
                Semester semester;

                if (j == 1) {
                    semester = year.getSemester1();
                } else {
                    semester = year.getSemester2();
                }

                transcript.append("\nSemester ").append(semester.getSemNumber()).append(":\n");
                double semesterQca = student.calculateQcaForSemester(semester.getSemNumber());
                // Loop through each result in a semester
                for (Result result : student.getResults()) {
                    // Check if the result belongs to the current semester
                    if (result.getSemester().getSemNumber() == semester.getSemNumber()) {
                         // Append module information and grade
                        transcript.append(result.getModule().getModuleId()).append("\t")
                                .append(result.getModule().getModuleName()).append("\t")
                                .append(result.getModule().getCredits()).append("\t")
                                .append(result.getGrade());
                        // Check if the module has to be repeated or if it's a passing fail
                        if ((result.getGrade().equalsIgnoreCase("F"))
                        || (result.getGrade().equalsIgnoreCase("NG"))
                        || ((result.getGrade().equalsIgnoreCase("D1")) && (student.calculateQcaForSemester(semester.getSemNumber()) < 2.0))
                        || ((result.getGrade().equalsIgnoreCase("D2")) && (student.calculateQcaForSemester(semester.getSemNumber()) < 2.0))) {
                            transcript.append("\tModule has to be repeated.");
                        } else if (((result.getGrade().equalsIgnoreCase("D1")) && (student.calculateQcaForSemester(semester.getSemNumber()) >= 2.0))
                        || ((result.getGrade().equalsIgnoreCase("D2")) && (student.calculateQcaForSemester(semester.getSemNumber()) >= 2.0))) {
                            transcript.append("\tPassing fail.");
                        }

                        transcript.append("\n");
                    }
                }
                // Append semester QCA
                transcript.append("\nSemester ").append(semester.getSemNumber()).append(" QCA: ")
                        .append(semesterQca).append("\n");
                // Append year QCA after the second semester
                if (j == 2) {
                    double yearQCA = student.calculateQcaForYear(year.getYearNumber());
                    transcript.append("\nYear ").append(year.getYearNumber()).append(" QCA: ")
                            .append(yearQCA).append("\n");
                }
            }
        }
          // Append overall QCA
        double overallQca = student.calculateQcaOverall();
        transcript.append("Overall QCA: ").append(overallQca).append("\n");
        // Return the transcript as a string
        return transcript.toString();
    }
}
