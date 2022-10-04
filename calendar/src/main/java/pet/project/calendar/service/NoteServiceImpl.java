package pet.project.calendar.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.dto.NoteDto;
import pet.project.calendar.entity.Event;
import pet.project.calendar.entity.Note;
import pet.project.calendar.exception.NoteNotFoundException;
import pet.project.calendar.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository notesRepository;

    @Autowired
    private EventService eventService;

    @Override
    public Note findNoteById(Integer id) {
        Optional<Note> not = notesRepository.findNoteById(id);
        if (not.isPresent()){
            return not.get();
        }else{
            throw new NoteNotFoundException("Note with id = " + id + " not found.");
        }
    }

    @Override
    public List<Note> findNotesByDescription(String description) {
        return (List<Note>) notesRepository.findNotesByDescription(description);
    }

    @Override
    public List<Note> findNotesByEventId(Integer eventId) {
        return (List<Note>) notesRepository.findNotesByEventId(eventId);
    }

    @Override
    public Note add(NoteDto noteDto) {
        String description = noteDto.getDescription();
        Integer eventId = noteDto.getEventId();

        Event event = eventService.findEventById(eventId);
        Note note = new Note(description, event);
        notesRepository.save(note);
        return note;
    }

    @Override
    public void updateNote(Integer id, String description) {
        notesRepository.updateNote(id, description);
    }

    @Override
    public void deleteNotesById(Integer id) {
        notesRepository.deleteNotesById(id);
    }

}
