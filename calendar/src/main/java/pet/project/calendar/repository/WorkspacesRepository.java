package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Workspaces;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface WorkspacesRepository extends CrudRepository<Workspaces, Integer> {

    Optional<Workspaces> findWorkspacesById(Integer integer);

    Iterable<Workspaces> findWorkspacesByName(String string);

    @Query("SELECT w FROM Workspaces w " +
           "JOIN Users us " +
           "ON w.userId = us " +
           "WHERE us.id = :id")
    Iterable<Workspaces> findWorkspacesByUserId(@Param("id") Integer id);

    @Transactional
    void deleteWorkspacesById(Integer integer);

    @Transactional
    void deleteWorkspacesByName(String string);
}
