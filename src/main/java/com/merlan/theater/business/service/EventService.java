package com.merlan.theater.business.service;

import com.merlan.theater.business.domain.EventRating;
import com.merlan.theater.data.entity.Auditorium;
import com.merlan.theater.data.entity.Event;
import com.merlan.theater.data.repository.AuditoriumRepository;
import com.merlan.theater.data.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author meilan_xie
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    private AuditoriumRepository auditoriumRepository;

    /**
     * save an event
     * @param movieName movieName of the event
     * @param rating rating of the event
     * @param airDate airDate of the event
     * @param auditorium auditorium of the event
     * @param basePrice basePrice of the event
     * @return removed user or empty
     */
    public @Nullable Event saveEvent(@Nonnull String movieName,@Nullable EventRating rating, @Nonnull LocalDateTime airDate, @Nonnull Auditorium auditorium,@Nonnull Double basePrice){
        return null;
    }
    /**
     * Remove an event
     * @param movieName movieName of the event
     * @param rating rating of the event
     * @param airDate airDate of the event
     * @param auditoriumId auditoriumId of the event
     * @param eventId eventId of the event
     * @return removed user or empty
     */
    public @Nullable Event removeEvent(@Nonnull String movieName,@Nullable EventRating rating, @Nonnull LocalDateTime airDate, @Nullable Long auditoriumId, @Nullable Long eventId){
        return null;
    }
    /**
     * Finding all events
     * @return all events or <code>null</code>
     */
    public @Nullable Set<Event> getAll(){
        return null;
    }

    /**
     * Finding event by id
     *
     * @param eventId
     *            eventId of the event
     * @return found event or <code>null</code>
     */
    public @Nullable Event getEventById(@Nonnull Long eventId){
        return null;
    }
    /**
     * @param name
     *            Name of the event
     * @return found event or <code>null</code>
     */
    public @Nullable Set<Event> getEventByName(@Nonnull String name) {
        return null;
    }
    /**
     * Finding all events that air on specified date range
     *
     * @param from Start date
     * @param to   End date inclusive
     * @return Set of events
     * Finding event by data
     */
    public @Nullable Set<Event> getEventForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to){
        return null;
    }

    /**
     * Return events from 'now' till the the specified date time
     *
     * @param to End date time inclusive
     * s
     * @return Set of events
     */
    public @Nullable Set<Event> getEventNextEvents(@Nonnull LocalDate to) {
        return null;
    }
}
