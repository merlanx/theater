package com.merlan.theater.data.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author meilan_xie
 */
@Entity
@Table(name="TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TICKET_ID")
    private long id;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "EVENT_ID")
    private Event event;
    @Column(name = "SEAT")
    private String seat;
    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PRICING_STRATEGY_ID")
    private Set<PricingStrategy> pricingStrategies = new HashSet<>();
    @Column(name="PRICE")
    private double price;


    public Ticket(User user, Event event, String seat) {
        this.user = user;
        this.event = event;
        this.seat = seat;
    }

       @Override
    public int hashCode() {
        return Objects.hash(event, seat);
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        Ticket other = (Ticket) obj;
        if (event == null) {
            if (other.event != null) {
                return false;
            }
        } else if (!event.equals(other.event)) {
            return false;
        }
        if (seat == null) {
            if (other.seat != null) {
                return false;
            }
        } else if (!seat.equals(other.seat)) {
            return false;
        }
        return true;
    }
}
