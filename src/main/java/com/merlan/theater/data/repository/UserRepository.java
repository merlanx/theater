package com.merlan.theater.data.repository;

/**
 * @author
 */
/**
 * TODO: TO ADD FUNCTION
 */
import com.merlan.theater.data.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}