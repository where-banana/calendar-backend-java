package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.entity.Notes;
import pet.project.calendar.exception.NotesNotFoundException;
import pet.project.calendar.service.NotesService;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private NotesService notesService;

    @Autowired
    public void setNotesService(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/findNotesById/{id}")
    public ResponseEntity<Notes> findNotesById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(notesService.findNotesById(id), HttpStatus.OK);
        }catch (NotesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findNotesByDescription/{description}")
    public ResponseEntity<List<Notes>> findNotesByDescription(@PathVariable("description") String description){
        try {
            List<Notes> notesList = notesService.findNotesByDescription(description);
            return new ResponseEntity<>(notesList, HttpStatus.OK);
        }catch (NotesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findNotesByEventId/{eventId}")
    public ResponseEntity<List<Notes>> findNotesByEventId(@PathVariable("eventId") Integer eventId){
        try {
            List<Notes> notesList = notesService.findNotesByEventId(eventId);
            return new ResponseEntity<>(notesList, HttpStatus.OK);
        }catch (NotesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteNotesById/{id}")
    public ResponseEntity<Notes> deleteNotesById(@PathVariable("id") Integer id){
        try {
            notesService.deleteNotesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/deleteNotesByDescription/{description}")
    public ResponseEntity<Notes> deleteNotesByDescription(@PathVariable("description") String description){
        try{
            notesService.deleteNotesByDescription(description);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotesNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
