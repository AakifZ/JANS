import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

public class JDBC {
    static Connection connection = null;

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            connector();
            DBCreationReader();
        } catch (SQLException e) {
            System.out.println("Could not connect to database.\n   Please try again later.");
        }

        System.out.println(addStudent("Berry", "Johnson", "berJo@gmail.com", 3.8));
        System.out.println(addStudent("Jimmy", "Neutron", "brainblast@gmail.com", 3.4));
        System.out.println(deleteStudent(1));
        System.out.println(addStudent("Barney", "The big red dog", "berensteinbears@gmail.com", 3.1));
        System.out.println(addStudent("Fred", "Fazbear", "FredF123@aol.com", 3.5));
        System.out.println(addStudent("Johnny", "Appleseed", "JApple@gmail.com", 3.2));
        System.out.println("Creating exam: " + createExam(1, "this"));
        System.out.println("Student 1's gpa is: " + getStudentGPA(1));
        System.out.println("Student 5's gpa is: " + getStudentGPA(5));
        System.out.println(addExamScore(2, 1, 90));
        System.out.println(addExamScore(5, 1, 80));
        System.out.println("Student 2's exam score is: " + getStudentExamScore(2, 1));
        System.out.println("Student 5's exam score is: " + getStudentExamScore(5, 1));
        System.out.println("Adding a sys admin: " + addSysAdmin(1,"Jake", "from Statefarm", "jakegylenhaal@gmail.com"));
        System.out.println("Adding professor: " + addProfessor(1,"bob", "marley", "bobmarley@gmail.com", "1231231234", 1));
        System.out.println("Adding course: " + addCourse(1,1,"CMSC", "This is a cs class"));
        //System.out.println("Deleting course: " + deleteCourse(1));
        System.out.println("Adding student: " + addStudentToCourse(2, 1, 80.2));
        System.out.println("Adding student: " + addStudentToCourse(3, 1, 90));
        System.out.println("Adding student: " + addStudentToCourse(4, 1, 50));
        System.out.println("Adding student: " + addStudentToCourse(5, 1, 80));
        System.out.println("The class average for class 1 is: " + getClassGradeAverage(1));

    }

    public static void connector() throws ClassNotFoundException, SQLException {
        // establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Chocolate123";
        connection = DriverManager.getConnection(url, user, password);
    }

    public static void DBCreationReader() {
        try {
            Statement statement = connection.createStatement();
            String strCurrentLine;
            StringBuilder fileString = new StringBuilder();

            BufferedReader sqlReader = new BufferedReader(new FileReader("src\\main\\sql\\gsdatabase.sql"));

            while ((strCurrentLine = sqlReader.readLine()) != null) {
                if (strCurrentLine.length() < 1 || strCurrentLine.startsWith("--")) {
                    continue;
                }
                fileString.append(strCurrentLine);
            }

            String[] queries = fileString.toString().split(";");
            for (String q : queries) {
                statement.executeUpdate(q);
            }
            sqlReader.close();

        } catch (SQLException a) {
            System.out.println("Issue with reading through the queries.");
            a.printStackTrace();
        } catch (FileNotFoundException b) {
            System.out.println("File is not found, please get another file.");
        } catch (Exception e) {
            System.out.println("Unexpected Error has Occurred.");
        }
    }

    /**
     * Adds a student to the database and auto assigns the student an ID number
     *
     * @param firstName The student's first name
     * @param lastName  The student's last name
     * @param email     The student's email address
     * @param gpa       The student's semester gpa
     * @return true if the student was added to the database
     * false if the student could not be added to the database
     */
    public static boolean addStudent(String firstName, String lastName, String email, double gpa) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into student(first_name, last_name, email, gpa) values('%s', '%s', '%s', '%f')", firstName, lastName, email, gpa);
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("There was a problem adding the student. Please try again.");
        }
        return result > 0;
    }

    public static boolean createExam(int exam_number, String ... nameDesc) {
        int result = 0;
        String name = nameDesc.length > 0 ? nameDesc[0]: null;
        String desc = nameDesc.length > 1 ? nameDesc[1]: null;

        try{
            Statement statement = connection.createStatement();
            String query = String.format("insert into exam(name, feedback) values ('%s', '%s');", name, desc);
            result = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Exam could not be created.");
            e.printStackTrace();
        }
        return result > 0;
    }
    /**
     * Adds the exam score for the corresponding Student
     *
     * @param IDNumber the Student's ID number
     * @param ExamNumber The Exam number where the score needs to be added
     * @param ExamScore the Exam score that is added
     * @return returns true if score is added, false if score is not added
     */
    public static boolean addExamScore(int IDNumber, int ExamNumber, double ExamScore){
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into student_exam(student_ID, exam_number, exam_grade) values (%d, %d,%f);", IDNumber, ExamNumber, ExamScore);
            result = statement.executeUpdate(query);
        } catch (SQLException e){
            System.out.println("There was a problem adding exam score");
        }
        return result > 0;
    }

    /**
     * Deletes a student given the student's ID Number
     * @param IDNumber student's ID number
     * @return true if the student was successfully deleted from the database
     * false if the student could not be deleted from the database
     */
    public static boolean deleteStudent(int IDNumber) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from student where student_ID = %d", IDNumber);
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("There was a problem deleting the student. Please try again.");
        }
        return result > 0;
    }

    /**
     * Get a student's current semester GPA by passing in the student's ID number
     * @param IDNumber the student's ID number
     * @return the student's current semester GPA
     */
    public static double getStudentGPA(int IDNumber) {
        double gpa = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select gpa from student where student_ID = %d", IDNumber);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                gpa = rs.getDouble("gpa");
            }
        } catch (SQLException e) {
            System.out.println("There was a problem locating the student's GPA");

        }
        return gpa;
    }

    /**
     * gets the exam score for the corresponding student
     * @param IDNumber the student ID number used to add the score
     * @param ExamNumber the exam number where the score is added
     * @return returns the student score
     */
    public static int getStudentExamScore(int IDNumber, int ExamNumber){
        int score = 0;
        try{
            Statement statement = connection.createStatement();
            String query = String.format("select exam_grade from student_exam where student_ID = %d and exam_number = %d", IDNumber, ExamNumber);
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                score = result.getInt("exam_grade");
            }

        } catch (SQLException e){
            System.out.println("There is no exam score for this student");
        }
        return score;
    }

    public static void compareGrades(int IDNumber){

        if (getStudentExamScore(5, 1) > getClassGradeAverage(1)){
            System.out.println("Your grade is higher than the class average");
        }
        else {
            System.out.println("Your grade is lower than the class average");
        }

    }

    /**
     * Add a course to the system
     * @param courseID the ID of the course
     * @param professorID the ID of the professor teaching the class
     * @param courseName the name of the course
     * @param desc the description of the course
     * @return true if the course was created and added to database
     * false if course could not be created and added
     */
    public static boolean addCourse(int courseID, int professorID, String courseName, String ... desc) {
        int result = 0;
        String description = desc.length > 0 ? desc[0] : null;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into course(course_ID, professor_ID, course_name, course_description) values(%d, %d, '%s', '%s')", courseID, professorID, courseName, description);
            result = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Course could not be added.");
            e.printStackTrace();
        }
        return result > 0;
    }

    public static boolean addStudentToCourse(int student_ID, int course_ID, double course_grade) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into course_enrollment values(%d, %d, %f)", student_ID, course_ID, course_grade);
            result = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("The student could not be added to the course.");
            e.printStackTrace();
        }
        return result > 0;
    }

    /**
     * Delete the course with the associated course ID number
     * @param courseID the course to be deleted
     * @return true if the course was deleted
     * false if the course could not be deleted
     */
    public static boolean deleteCourse(int courseID) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from course where course_ID = %d;", courseID);
            result = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("The course with Course ID: '" + courseID + "' could not be deleted.");
        }
        return result > 0;
    }

    /**
     * Get the average percentage of all the students in the class
     * @param courseID the class that the average is calculated from
     * @return the class grade average
     */
    public static double getClassGradeAverage(int courseID) {
        double avg = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select avg(course_grade) from course_enrollment where course_ID = %d;", courseID);
            ResultSet result = statement.executeQuery(query);
            while(result.next()) {
                avg = result.getDouble("avg(course_grade)");
            }
        } catch (Exception e) {
            System.out.println("The class grade average could not be calculated.");
        }
        return avg;
    }

    /**
     * Add a professor to the system
     * @param professor_ID the ID unique to each professor
     * @param firstName the first name that is corresponding to the professor
     * @param lastName the last name that is corresponding to the professor
     * @param email the email that the professor uses to contact students
     * @return True if professor gets added to the system
     *         False if professor does not get added to the system
     */
    public static boolean addProfessor(int professor_ID, String firstName, String lastName, String email, String phone, int sysAdmin) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into professor values('%d', '%s', '%s','%s','%s','%d')", professor_ID, firstName, lastName, email, phone, sysAdmin);
            result = statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Problem has occurred and the professor could not be added");
        }
        return result > 0;

    }

    /**
     * Delete a professor in the system
     * @param professor_ID the ID unique to the professor
     * @return True if professor gets deleted
     *         False if professor does not get deleted
     */
        public static boolean deleteProfessor(int professor_ID) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from professor where professor_ID = %d", professor_ID);
            result = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("There was a problem deleting the professor. Please try again.");
        }
        return result > 0;
    }

    public static boolean addSysAdmin(int ID, String firstName, String lastName, String email) {
        int result = 0;
        try {
            Statement statement = connection.createStatement();
            String query = String.format("insert into sysadmin values('%d','%s','%s','%s');", ID, firstName, lastName, email);
            result = statement.executeUpdate(query);
        }catch (Exception e) {
            System.out.println("There was a problem adding the systems administrator.");
        }
        return result > 0;
    }
}