package objects;

public class examListJC {
int exam_number;
String exam_name;
String feedback;

    public examListJC(int exam_number, String exam_name, String feedback) {
        this.exam_number = exam_number;
        this.exam_name = exam_name;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
