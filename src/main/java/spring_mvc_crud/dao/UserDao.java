package spring_mvc_crud.dao;

import spring_mvc_crud.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    void updateUser(User user);

    User getUserByName(String userName);

}
