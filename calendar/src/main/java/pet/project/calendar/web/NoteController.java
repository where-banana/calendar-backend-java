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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/entity-management")
public class NoteController {

    private NoteService notesService;

    @Autowired
    public void setNotesService(NoteService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Map<String, Object>> findNotesById(@PathVariable("id") Integer id){
        try{
            Note note = notesService.findNoteById(id);
            String description = note.getDescription();
            Boolean checked = note.isChecked();

            Map<String, Object> noteMap = new HashMap<>();
            noteMap.put("description", description);
            noteMap.put("checked", checked);

            return new ResponseEntity<>(noteMap, HttpStatus.OK);
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
    public void updateNote(@PathVariable Integer id, @RequestBody Map<String, Object> json){
        notesService.updateNote(id, (String) json.get("description"), (Boolean) json.get("checked"), (Integer) json.get("eventId"));
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

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> findAll(){
        try{
            return new ResponseEntity<>(notesService.findAll(), HttpStatus.OK);
        }catch (NoteNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
