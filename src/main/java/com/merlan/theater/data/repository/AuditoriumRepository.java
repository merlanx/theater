package com.merlan.theater.data.repository;

/**
 * @author meilan_xie
 */

import com.merlan.theater.data.entity.Auditorium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {
   @Query("select a from Auditorium a where upper(a.name) = upper(:name)")
   Auditorium findByName(@Param("name") String name);

}