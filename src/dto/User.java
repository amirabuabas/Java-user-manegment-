package dto;

public class User {

    // Fields
    private int ID;
    private String Name;
    private String Email;
    private int Student_ID;
    private int Student_Roll_Number;

    public User(int iD, String name, String email, int student_ID, int student_Roll_Number) {
        ID = iD;
        Name = name;
        Email = email;
        Student_ID = student_ID;
        Student_Roll_Number = student_Roll_Number;
    }

    // Default Constructor
    public User() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_id) {
        this.Student_ID = Student_id;
    }

    public int getStudent_Roll_Number() {
        return Student_Roll_Number;
    }

    public void setStudent_Roll_Number(int Student_Roll_Number) {
        this.Student_Roll_Number = Student_Roll_Number;
    }

    public void showInfo() {
        System.out.println(ID + " \t" + Name + "\t" + Email + "\t" + Student_ID + "\t" + Student_Roll_Number);
    }

}
