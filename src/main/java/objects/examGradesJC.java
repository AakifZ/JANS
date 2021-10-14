package objects;

public class examGradesJC {
    int student_ID;
    String first_Name;
    String last_Name;
    int exam_number;
    double exam_grade;

    public examGradesJC(int student_ID, String first_Name, String last_Name, int exam_number, double exam_grade) {
        this.student_ID = student_ID;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.exam_number = exam_number;
        this.exam_grade = exam_grade;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
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
