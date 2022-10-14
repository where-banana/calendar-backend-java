package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.dto.UserDto;
import pet.project.calendar.entity.User;
import pet.project.calendar.exception.UserNotFoundException;
import pet.project.calendar.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public User findUserById(Integer id) {
        Optional<User> us = usersRepository.findUserById(id);
        if(us.isPresent()){
            return us.get();
        }else{
            throw new UserNotFoundException("User with id = " + id + " not found.");
        }
    }

    @Override
    public List<User> findUsersByName(String name) {
        return (List<User>) usersRepository.findUsersByName(name);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public User add(UserDto userDto) {
        User user = new User(userDto.getName());
        usersRepository.save(user);
        return user;
    }

    @Override
    public void updateUserName(Integer id, String name) {
        usersRepository.updateUserName(id, name);
    }

    @Override
    public void deleteUsersById(Integer id) {
        usersRepository.deleteUsersById(id);
    }
}
