package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Notes;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Integer> {

    Optional<Notes> findNotesById(Integer integer);

    Iterable<Notes> findNotesByDescription(String string);

    @Query("SELECT n FROM Notes n " +
           "JOIN Events ev " +
           "ON n.eventId = ev " +
           "WHERE ev.id = :id")
    Iterable<Notes> findNotesByEventId(@Param("id") Integer id);

    @Transactional
    void deleteNotesById(Integer integer);

    @Transactional
    void deleteNotesByDescription(String string);
}
