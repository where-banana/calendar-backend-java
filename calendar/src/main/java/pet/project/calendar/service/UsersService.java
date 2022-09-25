package pet.project.calendar.service;

import pet.project.calendar.entity.Users;

import java.util.List;

public interface UsersService {

    Users findUsersById(Integer id);

    List<Users> findUsersByName(String name);

    List<Users> findAll();

    void deleteUsersById(Integer id);
}
