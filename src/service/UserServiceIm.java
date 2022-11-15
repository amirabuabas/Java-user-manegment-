package service;

import java.util.List;

import dao.StudentDAO;
import dao.StudentMySQLIml;
import dto.User;

public class UserServiceIm implements UserService {
    private StudentDAO userDAO = new StudentMySQLIml();

    @Override
    public void insert(User user) {
        userDAO.insert(user);
    }   

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }



}
