package objects;

public class AdminCourse {
    int course_ID;
    int professor_ID;
    String course_name;
    String course_description;
    int sysAdmin;

    public AdminCourse(int course_ID, int professor_ID, String course_name, String course_description, int sysAdmin) {
        this.course_ID = course_ID;
        this.professor_ID = professor_ID;
        this.course_name = course_name;
        this.course_description = course_description;
        this.sysAdmin = sysAdmin;
    }

    public int getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    public int getProfessor_ID() {
        return professor_ID;
    }

    public void setProfessor_ID(int professor_ID) {
        this.professor_ID = professor_ID;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public int getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(int sysAdmin) {
        this.sysAdmin = sysAdmin;
    }
}
