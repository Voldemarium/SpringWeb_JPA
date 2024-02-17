package ru.synergy.springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.synergy.springJPA.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameContaining(String name);

    @Query("select u from User u where upper(u.name) like upper(:name)")
    Optional<User> findThisGuy(@Param("name") String name);

}