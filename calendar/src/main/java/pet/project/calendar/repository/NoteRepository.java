package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Note;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

    Optional<Note> findNoteById(Integer integer);

    Iterable<Note> findNotesByDescription(String string);

    @Query("SELECT n FROM Note n " +
           "JOIN Event ev " +
           "ON n.eventId = ev " +
           "WHERE ev.id = :id")
    Iterable<Note> findNotesByEventId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Note n " +
           "SET n.description = :newDescription " +
           "WHERE n.id = :id")
    void updateNote(@Param("id") Integer id,
                    @Param("newDescription") String description);

    @Transactional
    void deleteNotesById(Integer integer);

}
