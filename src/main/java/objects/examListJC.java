package objects;

public class examListJC {
int exam_ID;
String exam_Name;

String feedback;

    public examListJC(int exam_ID, String exam_Name, String feedback) {
        this.exam_ID = exam_ID;
        this.exam_Name = exam_Name;
        this.feedback = feedback;
    }

    public int getExam_ID() {
        return exam_ID;
    }

    public void setExam_ID(int exam_ID) {
        this.exam_ID = exam_ID;
    }

    public String getExam_Name() {
        return exam_Name;
    }

    public void setExam_Name(String exam_Name) {
        this.exam_Name = exam_Name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
