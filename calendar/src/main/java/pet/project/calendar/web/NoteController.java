package pet.project.calendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pet.project.calendar.dto.NoteDto;
import pet.project.calendar.entity.Note;
import pet.project.calendar.exception.NoteNotFoundException;
import pet.project.calendar.service.NoteService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService notesService;

    @Autowired
    public void setNotesService(NoteService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/findNoteById/{id}")
    public ResponseEntity<Note> findNotesById(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity<>(notesService.findNoteById(id), HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findNotesByDescription/{description}")
    public ResponseEntity<List<Note>> findNotesByDescription(@PathVariable("description") String description){
        try {
            List<Note> notesList = notesService.findNotesByDescription(description);
            return new ResponseEntity<>(notesList, HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/findNotesByEventId/{eventId}")
    public ResponseEntity<List<Note>> findNotesByEventId(@PathVariable("eventId") Integer eventId){
        try {
            List<Note> notesList = notesService.findNotesByEventId(eventId);
            return new ResponseEntity<>(notesList, HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Note> addNote(@RequestBody NoteDto noteDto){
        try{
            Note note = notesService.addNote(noteDto);
            return new ResponseEntity<>(note, HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

//TODO update note
    @PutMapping("/updateNote/{id}")
    public void updateNote(@PathVariable Integer id, @RequestBody Map<String, String> json){
        notesService.updateNote(id, json.get("description"));
    }

    @DeleteMapping("/deleteNotesById/{id}")
    public ResponseEntity<Note> deleteNotesById(@PathVariable("id") Integer id){
        try {
            notesService.deleteNotesById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
