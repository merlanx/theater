package com.merlan.theater.data.entity;
import com.merlan.theater.business.domain.EventRating;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author meilan_xie
 */
@Entity
@Table(name="EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EVENT_ID")
    private long id;
    @Column(name="MOVIE_NAME")
    private String movieName;
    @Column(name="RATING")
    private EventRating rating;
    @Column(name="AIR_DATE")
    private LocalDateTime airDate;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="AUDITORIUM_ID")
    private Auditorium auditorium;
    @Column(name="BASE_PRICE")
    private double basePrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    public LocalDateTime getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDateTime airDate) {
        this.airDate = airDate;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Event other = (Event) obj;
        if (movieName == null) {
            if (other.movieName != null) {
                return false;
            }
        } else if (!movieName.equals(other.movieName)) {
            return false;
        }
        if (airDate == null) {
            if (other.airDate != null) {
                return false;
            }
        } else if (!airDate.equals(other.airDate)) {
            return false;
        }
        if (auditorium == null) {
            if (other.auditorium != null) {
                return false;
            }
        } else if (!auditorium.equals(other.auditorium)) {
            return false;
        }
        return true;
    }

}
