package objects;

public class Student {
    int student_ID;
    String first_name;
    String last_name;
    String email;
    double gpa;
    int sysAdmin;
    String password;

    public Student(int student_ID, String first_name, String last_name, String email, double gpa, int sysAdmin, String password) {
        this.student_ID = student_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gpa = gpa;
        this.sysAdmin = sysAdmin;
        this.password = password;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(int sysAdmin) {
        this.sysAdmin = sysAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
