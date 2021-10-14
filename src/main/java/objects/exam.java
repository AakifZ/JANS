package objects;

public class exam {
public static int exam_number;
public static String exam_name;
public static double exam_grade;
public static String feedback;



    @Override
    public String toString() {
        return "exam{" +
                "exam_number=" + exam_number +
                ", exam_name='" + exam_name + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    public exam(int exam_number, String exam_name, double exam_grade, String feedback) {
        this.exam_number = exam_number;
        this.exam_name = exam_name;
        this.exam_grade = exam_grade;
        this.feedback = feedback;
    }

    public int getExam_number() {
        return exam_number;
    }

    public void setExam_number(int exam_number) {
        this.exam_number = exam_number;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public double getExam_grade() {
        return exam_grade;
    }

    public void setExam_grade(int exam_grade) { this.exam_grade = exam_grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
