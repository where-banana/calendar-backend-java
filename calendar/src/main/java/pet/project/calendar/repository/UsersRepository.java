package pet.project.calendar.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.Users;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findById(Integer integer);

    Iterable<Users> findByName(String string);

    Iterable<Users> findAll();

    @Transactional
    void deleteUsersById(Integer integer);
}
