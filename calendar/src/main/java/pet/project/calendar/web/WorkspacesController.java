package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.entity.Workspaces;
import pet.project.calendar.exception.WorkspacesNotFoundException;
import pet.project.calendar.service.WorkspacesService;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
public class WorkspacesController {

    private WorkspacesService workspacesService;

    @Autowired
    public void setWorkspacesService(WorkspacesService workspacesService) {
        this.workspacesService = workspacesService;
    }

    @GetMapping("/findWorkspacesById/{id}")
    public ResponseEntity<Workspaces> findWorkspacesById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(workspacesService.findWorkspacesById(id), HttpStatus.OK);
        }catch (WorkspacesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findWorkspacesByName/{name}")
    public ResponseEntity<List<Workspaces>> findWorkspacesByName(@PathVariable("name") String name){
        try{
            List<Workspaces> workspacesList = workspacesService.findWorkspacesByName(name);
            return new ResponseEntity<>(workspacesList, HttpStatus.OK);
        }catch (WorkspacesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findWorkspacesByUserId/{userId}")
    public ResponseEntity<List<Workspaces>> findWorkspacesByUserId(@PathVariable("userId") Integer userId){
        try {
            List<Workspaces> workspacesList = workspacesService.findWorkspacesByUserId(userId);
            return new ResponseEntity<>(workspacesList, HttpStatus.OK);
        }catch (WorkspacesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteWorkspacesById/{id}")
    public ResponseEntity<Workspaces> deleteWorkspacesById(@PathVariable("id") Integer id){
        try {
            workspacesService.deleteWorkspacesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (WorkspacesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteWorkspacesByName/{name}")
    public ResponseEntity<Workspaces> deleteWorkspacesByName(@PathVariable("name") String name){
        try {
            workspacesService.deleteWorkspacesByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (WorkspacesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


}
