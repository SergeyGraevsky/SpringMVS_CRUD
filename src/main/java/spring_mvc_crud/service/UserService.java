package spring_mvc_crud.service;

import spring_mvc_crud.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    void updateUser(User user);

    User getUserByName(String userName);

    User getUserByPassword(String password);
}
