package pet.project.calendar.service;

import pet.project.calendar.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(Integer id);

    List<User> findUsersByName(String name);

    List<User> findAll();

    void updateUserName(Integer id, String name);

    void deleteUsersById(Integer id);
}
