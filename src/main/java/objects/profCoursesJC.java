package objects;

public class profCoursesJC {
    int course_ID;
    String course_Name;
    String course_description;

    public profCoursesJC(int course_ID, String course_Name, String course_description) {
        this.course_ID = course_ID;
        this.course_Name = course_Name;
        this.course_description = course_description;
    }

    public int getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    public String getCourse_Name() {
        return course_Name;
    }

    public void setCourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
}
