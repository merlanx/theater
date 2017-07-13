package com.merlan.theater.data.repository;

/**
 * @author meilan_xie
 */

import com.merlan.theater.data.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);
    @Query("select u from User u where u.userId = :userId")
    User findByUserId(@Param("userId") Long userId);
    @Query("select u from User u")
    Set<User> findAll();
}