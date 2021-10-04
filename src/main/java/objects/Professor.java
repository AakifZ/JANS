package objects;

public class Professor {
    int professor_ID;
    String first_name;
    String last_name;
    String email;
    String phone;
    int admin;
    String password;

    public Professor(String first_name, String last_name, String email, String phone, int admin, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Professor(int professor_ID, String first_name, String last_name, String email, String phone, int admin, String password) {
        this.professor_ID = professor_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
        this.password = password;
    }

    public int getProfessor_ID() {
        return professor_ID;
    }

    public void setProfessor_ID(int professor_ID) {
        this.professor_ID = professor_ID;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
