package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Workspace;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface WorkspaceRepository extends CrudRepository<Workspace, Integer> {

    Optional<Workspace> findWorkspaceById(Integer integer);

    Iterable<Workspace> findWorkspacesByName(String string);

    @Query("SELECT w FROM Workspace w " +
           "JOIN User us " +
           "ON w.userId = us " +
           "WHERE us.id = :id")
    Iterable<Workspace> findWorkspacesByUserId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Workspace w " +
           "SET w.name = :name " +
           "WHERE w.id = :id")
    void updateWorkspace(@Param("id") Integer id,
                         @Param("name") String name);

    @Transactional
    void deleteWorkspacesById(Integer integer);

    @Transactional
    void deleteWorkspacesByName(String string);
}
