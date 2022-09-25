package pet.project.calendar.service;

import pet.project.calendar.entity.Notes;

import java.util.List;

public interface NotesService {

    Notes findNotesById(Integer id);

    List<Notes> findNotesByDescription(String description);

    List<Notes> findNotesByEventId(Integer eventId);

    void deleteNotesById(Integer id);

    void deleteNotesByDescription(String description);

}
