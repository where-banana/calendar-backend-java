package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.UserDto;
import pet.project.calendar.entity.User;
import pet.project.calendar.exception.UserNotFoundException;
import pet.project.calendar.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity-management")
public class UserController {

    private UserService usersService;

    @Autowired
    public void setUsersService(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(usersService.findUserById(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Deprecated
    @GetMapping("/users/{name}")
    public ResponseEntity<List<User>> findUsersByName(@PathVariable("name") String name){
        try {
            List<User> usersList = usersService.findUsersByName(name);
            return new ResponseEntity<>(usersList, HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> add(@RequestBody UserDto userDto){
        User user = usersService.add(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @PutMapping("/updateUserName/{id}")
    public void updateUserName(@PathVariable Integer id, @RequestBody Map<String, String> json){
        usersService.updateUserName(id, json.get("name"));
    }

    @DeleteMapping("/deleteUsersById/{id}")
    public ResponseEntity<User> deleteUsersById(@PathVariable("id") Integer id){
        try{
            usersService.deleteUsersById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
