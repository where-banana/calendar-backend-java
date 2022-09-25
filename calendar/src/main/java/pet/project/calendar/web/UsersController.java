package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.entity.Users;
import pet.project.calendar.exception.UsersNotFoundException;
import pet.project.calendar.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Users> findUsersById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(usersService.findUsersById(id), HttpStatus.OK);
        } catch (UsersNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findUsersByName/{name}")
    public ResponseEntity<List<Users>> findUsersByName(@PathVariable("name") String name){
        try {
            List<Users> usersList = usersService.findUsersByName(name);
            return new ResponseEntity<>(usersList, HttpStatus.OK);
        }catch (UsersNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Users>> findAll(){
        try{
            List<Users> usersList = usersService.findAll();
            return new ResponseEntity<>(usersList, HttpStatus.OK);
        }catch (UsersNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteUsersById/{id}")
    public ResponseEntity<Users> deleteUsersById(@PathVariable("id") Integer id){
        try{
            usersService.deleteUsersById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UsersNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
