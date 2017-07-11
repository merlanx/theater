package com.merlan.theater.data.repository;

/**
 * @author
 */
/**
 * TODO: TO ADD FUNCTION
 */
import com.merlan.theater.data.entity.Auditorium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {
    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     *
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
   /* public long countVipSeats(Collection<Long> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }*/
}