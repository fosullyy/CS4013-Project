/**
 * Represents a programme (or course) within UL.
 */
public class Programme {
    private String programmeName;
    private Department department;

    /**
     * Constructs Programme object with its name and the department it belongs to.
     * @param programmeName The name of the programme.
     * @param department The department the programme belongs to.
     */
    public Programme(String programmeName, Department department) {
        this.programmeName = programmeName;
        this.department = department;
    }
    //Used in csv file to read Name of programme student is doing
    public Programme(String programmeName){
        this.programmeName = programmeName;
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
     * Gets the department of the programme.
     *
     * @return The department of the programme.
     */
    public Department getDepartment() {
        return department;
    }
}
