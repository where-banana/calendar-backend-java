package pet.project.calendar.service;

import pet.project.calendar.dto.NoteDto;
import pet.project.calendar.entity.Note;

import java.util.List;

public interface NoteService {

    Note findNoteById(Integer id);

    List<Note> findNotesByDescription(String description);

    List<Note> findNotesByEventId(Integer eventId);

    Note add(NoteDto noteDto);

    void updateNote(Integer id, String description, Boolean checked, Integer eventId);

    void deleteNotesById(Integer id);

    List<Note> findAll();

}
