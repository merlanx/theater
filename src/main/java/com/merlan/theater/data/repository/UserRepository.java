package com.merlan.theater.data.repository;

/**
 * @author meilan_xie
 */


import com.merlan.theater.data.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email in (:email)")
    List<User> findByEmails(@Param("email") List<String> email);
    @Query("select u from User u where upper(u.email) = upper(:email)")
    User findByEmail(@Param("email") String email);
    @Query("select u from User u where u.userId = :userId")
    User findByUserId(@Param("userId") Long userId);
    @Query("select u from User u")
    Set<User> findAll();
    @Modifying
    @Query("update User u set u.firstName = :firstName, u.lastName = :lastName, u.birthday = :birthday, u.numberOfTickets = :numberOfTickets where u.email = :email")
    void saveUser(@Param("firstName") String firstName,
                  @Param("lastName") String lastName,
                  @Param("email") String email,
                  @Param("birthday") Date birthday,
                  @Param("numberOfTickets") int numberOfTickets);
}