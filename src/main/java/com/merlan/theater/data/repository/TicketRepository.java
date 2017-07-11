package com.merlan.theater.data.repository;
/**
 * @author
 */
/**
 * TODO: TO ADD FUNCTION
 */

import com.merlan.theater.data.entity.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {



}