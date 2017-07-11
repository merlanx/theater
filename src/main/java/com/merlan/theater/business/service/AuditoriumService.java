package com.merlan.theater.business.service;

import com.merlan.theater.data.entity.Auditorium;
import com.merlan.theater.data.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author meilan_xie
 */
@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    /**
     * Getting all auditoriums from the system
     * 
     * @return set of all auditoriums
     */
    public @Nonnull Set<Auditorium> getAll() {
        Auditorium auditorium = new Auditorium();
        Set<Auditorium> auditoriums = new HashSet<>();
        auditoriums.add(auditorium);
        return auditoriums;
    }

    /**
     * Finding auditorium by name
     * 
     * @param name
     *            Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
   public @Nullable Auditorium getByName(@Nonnull String name) {
       return null;
   }

}
