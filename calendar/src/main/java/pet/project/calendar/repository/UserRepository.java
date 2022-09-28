package pet.project.calendar.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pet.project.calendar.entity.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserById(Integer integer);

    Iterable<User> findUsersByName(String string);

    Iterable<User> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE User u " +
           "SET u.name = :name " +
           "WHERE u.id = :id")
    void updateUserName(@Param("id") Integer id,
                        @Param("name") String name);

    @Transactional
    void deleteUsersById(Integer integer);
}
