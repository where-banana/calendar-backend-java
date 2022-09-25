package pet.project.calendar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Credentials;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, Integer> {

    Optional<Credentials> findCredentialsById(Integer integer);

    Optional<Credentials> findCredentialsByEmail(String string);
//TODO SHIT?
//    @Query("SELECT c FROM Credentials c " +
//           "JOIN Users us " +
//           "ON c.user = us " +
//           "WHERE us.id = :id")
//    Optional<Credentials> findByUserId(@Param("id") Integer id);

    Optional<Credentials> findCredentialsByUserId(Integer integer);

    Iterable<Credentials> findAll();

    @Transactional
    void deleteCredentialsById(Integer integer);
}
