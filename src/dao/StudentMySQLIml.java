package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dto.User;

public class StudentMySQLIml<Student> implements StudentDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String INSERT = "INSERT INTO Student_Records_T (ID, Name, email, Student_ID, Student_Roll_Number) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Student_Records_T SET ID = ?, Name =  ?, email = ?, Student_ID = ? Student_Roll_Number = ?, WHERE ID = ?";
    private static final String DELETE = "DELETE FROM Student_Records_T WHERE ID = ?";
    private static final String GET_BY_ID = "SELECT * FROM Student_Records_T WHERE ID = ?";
    private static final String GET_ALL = "SELECT * FROM Student_Records_T";

    public StudentMySQLIml() {
        try {
            connection = DriverManager.getConnection(StudentDAO.URL, StudentDAO.USER, StudentDAO.PASSWORD);
            System.out.println("Connected !");
        } catch (SQLException e) {
            System.out.println(" Unable to Connect !");
            e.printStackTrace();
        }
    }

    @Override
    public void insert(User user) {
        // We are using this extra variable for our own understanding that whatever operation we were doing was succesful,
        // and we want to tell the user or to us that yes these many rows were changed in database
        int rowAffected = 0;

        try {
            // preparedstatement takes a parameter which is SQL query where there maybe some dynamic values which we need to add
            preparedStatement = connection.prepareStatement(INSERT);

            // We are adding the values to the ? on the above queries we wrote by giving the index where they were and the value we get from the user object
            preparedStatement.setInt(1, user.getID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getStudent_ID());
            preparedStatement.setInt(5, user.getStudent_Roll_Number());
            // This returns number of rows cahnged/affected that's we are assigning it to our own variable
            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected");


        } catch (SQLException e) {
            System.out.println("Unable to insert data");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        if (rowAffected > 0) {
            System.out.println("Insert was succesful");
        }
    }



    @Override
    public void update(User user) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, user.getID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getStudent_ID());
            preparedStatement.setInt(5, user.getStudent_Roll_Number());

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected");


        } catch (SQLException e) {
            System.out.println("Unable to update data");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        if (rowAffected > 0) {
            System.out.println("Updatex was succesful");
        }
    }



    @Override
    public void delete( int ID) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, ID);

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected");


        } catch (SQLException e) {
            System.out.println("Unable to delete data");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        if (rowAffected > 0) {
            System.out.println("Delete was succesful");
        }
    }



    @Override
    public User getUserById(int ID) {
        User user = null;

        try {
            preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1,ID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                user = new User();
                user.setID(resultSet.getInt("ID"));
                user.setName(resultSet.getString("Name"));
                user.setEmail(resultSet.getString("Email"));
                user.setStudent_ID(resultSet.getInt("Student_ID"));
                user.setStudent_Roll_Number(resultSet.getInt("Student_Roll_Number"));
            }
        } catch (SQLException e) {
            System.out.println("Unable to find user for given id");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        return user;

    }

    @Override
    public List<User> getAll() {

        List<Student> userList = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setID(resultSet.getInt("ID"));
                user.setName(resultSet.getString("Name"));
                user.setEmail(resultSet.getString("Email"));
                user.setStudent_ID(resultSet.getInt("Student_ID"));
                user.setStudent_Roll_Number(resultSet.getInt("Student_Roll_Number"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Unable to find list of all users");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        return (List<User>) userList;

    }

    }
    

    



