package objects;

public class StudentExam {
    int student_ID;
    int exam_number;
    double exam_grade;

    public StudentExam(int student_ID, int exam_number, double exam_grade) {
        this.student_ID = student_ID;
        this.exam_number = exam_number;
        this.exam_grade = exam_grade;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public int getExam_number() {
        return exam_number;
    }

    public void setExam_number(int exam_number) {
        this.exam_number = exam_number;
    }

    public double getExam_grade() {
        return exam_grade;
    }

    public void setExam_grade(double exam_grade) {
        this.exam_grade = exam_grade;
    }
}
