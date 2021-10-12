package objects;

public class StudentExam{
    int exam_number;
    String exam_name;
    double exam_grade;
    String exam_feedback;

    public StudentExam(int exam_number, String exam_name, double exam_grade, String exam_feedback) {
        this.exam_number = exam_number;
        this.exam_name = exam_name;
        this.exam_grade = exam_grade;
        this.exam_feedback = exam_feedback;
    }

    public int getExam_number() {
        return exam_number;
    }

    public String getExam_name() {
        return exam_name;
    }

    public double getExam_grade() {
        return exam_grade;
    }

    public String getExam_feedback() {
        return exam_feedback;
    }

    public void setExam_number(int exam_number) {
        this.exam_number = exam_number;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public void setExam_grade(double exam_grade) {
        this.exam_grade = exam_grade;
    }

    public void setExam_feedback(String exam_feedback) {
        this.exam_feedback = exam_feedback;
    }
}