import java.util.ArrayList;

/**
 * Represents a programme (or course) within UL.
 */
public class Programme {
    private String programmeName;
    private String programmeId;
    private Department department;

    /**
     * Constructs Programme object with its name, ID and the department it belongs to.
     * @param programmeName The name of the programme.
     * @param programmeId The ID of the programme
     * @param department The department the programme belongs to.
     */
    public Programme(String programmeName, String programmeId, Department department,
                     ArrayList<Student> students) {
        this.programmeName = programmeName;
        this.programmeId = programmeId;
        this.department = department;
    }

    /**
     * Gets the name of the programme.
     *
     * @return The name of the programme.
     */
    public String getProgrammeName() {
        return programmeName;
    }

    /**
     * Gets the ID of the programme.
     *
     * @return The ID of the programme.
     */
    public String getProgrammeId() {
        return programmeId;
    }

    /**
     * Gets the department of the programme.
     *
     * @return The department of the programme.
     */
    public Department getDepartment() {
        return department;
    }
}
