package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.entity.Credentials;
import pet.project.calendar.exception.CredentialsNotFoundException;
import pet.project.calendar.service.CredentialsService;

import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialsController {

    private CredentialsService credentialsService;

    @Autowired
    public void setCredentialsService(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @GetMapping("/findCredentialsById/{id}")
    public ResponseEntity<Credentials> findCredentialsById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(credentialsService.findCredentialsById(id), HttpStatus.OK);
        }catch (CredentialsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findCredentialsByEmail/{email}")
    public ResponseEntity<Credentials> findCredentialsByEmail(@PathVariable("email") String email){
        try{
            return new ResponseEntity<>(credentialsService.findCredentialsByEmail(email), HttpStatus.OK);
        }catch (CredentialsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findCredentialsByUserId/{id}")
    public ResponseEntity<Credentials> findCredentialsByUserId(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(credentialsService.findCredentialsByUserId(id), HttpStatus.OK);
        }catch (CredentialsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Credentials>> findAll(){
        try {
            List<Credentials> credentialsList = credentialsService.findAll();
            return new ResponseEntity<>(credentialsList, HttpStatus.OK);
        } catch (CredentialsNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteCredentialsById/{id}")
    public ResponseEntity<Credentials> deleteCredentialsById(@PathVariable("id") Integer id){
        try{
            credentialsService.deleteCredentialsById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (CredentialsNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
