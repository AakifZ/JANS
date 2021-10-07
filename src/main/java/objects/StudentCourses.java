package objects;

public class StudentCourses {
    int courseID;
    String course_name;
    String course_description;
    int professor_ID;
    public StudentCourses(int courseID, String course_name, String course_description, int professor_ID) {
        this.courseID = courseID;
        this.course_name = course_name;
        this.course_description = course_description;
        this.professor_ID = professor_ID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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

    public int getProfessor_ID() {
        return professor_ID;
    }

    public void setProfessor_ID(int professor_ID) {
        this.professor_ID = professor_ID;
    }
}
