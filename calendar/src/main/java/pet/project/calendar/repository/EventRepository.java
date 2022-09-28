package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Event;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    Optional<Event> findEventById(Integer integer);

    Iterable<Event> findEventsByTitle(String name);

    @Query("SELECT e FROM Event e " +
           "JOIN Workspace w " +
           "ON e.workspacesId = w " +
           "WHERE w.id = :id")
    Iterable<Event> findEventsByWorkspacesId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Event e " +
           "SET e.title = :title " +
           "WHERE e.id = :id")
    void updateEvent(@Param("id") Integer id,
                     @Param("title") String title);

    @Transactional
    void deleteEventsById(Integer integer);

    @Transactional
    void deleteEventsByTitle(String name);
}
