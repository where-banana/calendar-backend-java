package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.entity.Users;
import pet.project.calendar.exception.UsersNotFoundException;
import pet.project.calendar.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findUsersById(Integer id) {
        Optional<Users> us = usersRepository.findUsersById(id);
        if(us.isPresent()){
            return us.get();
        }else{
            throw new UsersNotFoundException("User with id = " + id + " not found.");
        }
    }

    @Override
    public List<Users> findUsersByName(String name) {
        return (List<Users>) usersRepository.findUsersByName(name);
    }

    @Override
    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public void deleteUsersById(Integer id) {
        usersRepository.deleteUsersById(id);
    }
}
