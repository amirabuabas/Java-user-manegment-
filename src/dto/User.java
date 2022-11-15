package dto;

public class User {

    // Fields
    private int ID;
    private String Name;
    private String Email;
    private int Student_ID;
    private int Student_Roll_Number;

    // Parametrized constructor
    public User(String iD, String Name, String Email, String student_ID2, int student_Rool_Number) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.Student_ID = Student_ID;
        this.Student_Roll_Number = student_Rool_Number;
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
