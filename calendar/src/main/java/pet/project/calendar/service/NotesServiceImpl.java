package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.entity.Notes;
import pet.project.calendar.exception.NotesNotFoundException;
import pet.project.calendar.repository.NotesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService{

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Notes findNotesById(Integer id) {
        Optional<Notes> not = notesRepository.findNotesById(id);
        if (not.isPresent()){
            return not.get();
        }else{
            throw new NotesNotFoundException("Note with id = " + id + " not found.");
        }
    }

    @Override
    public List<Notes> findNotesByDescription(String description) {
        return (List<Notes>) notesRepository.findNotesByDescription(description);
    }

    @Override
    public List<Notes> findNotesByEventId(Integer eventId) {
        return (List<Notes>) notesRepository.findNotesByEventId(eventId);
    }

    @Override
    public void deleteNotesById(Integer id) {
        notesRepository.deleteNotesById(id);
    }

    @Override
    public void deleteNotesByDescription(String description) {
        notesRepository.deleteNotesByDescription(description);
    }
}
