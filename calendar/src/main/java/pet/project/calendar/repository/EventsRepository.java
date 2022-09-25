package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Events;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EventsRepository extends CrudRepository<Events, Integer> {

    Optional<Events> findById(Integer integer);

    Iterable<Events> findEventsByTitle(String name);

    @Query("SELECT e FROM Events e " +
           "JOIN Workspaces w " +
           "ON e.workspacesId = w " +
           "WHERE w.id = :id")
    Iterable<Events> findEventsByWorkspacesId(@Param("id") Integer id);

    @Transactional
    void deleteEventsById(Integer integer);

    @Transactional
    void deleteEventsByTitle(String name);
}
