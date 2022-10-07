package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.NoteDto;
import pet.project.calendar.entity.Note;
import pet.project.calendar.exception.NoteNotFoundException;
import pet.project.calendar.service.NoteService;

import java.util.Map;

@RestController
@RequestMapping("/entity-management")
public class NoteController {

    private NoteService notesService;

    @Autowired
    public void setNotesService(NoteService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> findNotesById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(notesService.findNoteById(id), HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(path = "/notes",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Note> add(@RequestBody NoteDto noteDto){
        Note note = notesService.add(noteDto);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable Integer id, @RequestBody Map<String, String> json){
        notesService.updateNote(id, json.get("description"));
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNotesById(@PathVariable("id") Integer id){
        try {
            notesService.deleteNotesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
