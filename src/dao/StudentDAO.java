package dao;

import java.util.List;

import dto.User;

public interface StudentDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/Student_Records_T";
    public static final String USER  = "root";
    public static final String PASSWORD = "asdfghjkl;";

    public void insert(User user);
    public void update(User user);
    public void delete(int id);
    public User getUserById(int id);
    public List<User> getAll();

}