package com.merlan.theater.data.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * @author meilan_xie
 */
@Entity
@Table(name="AUDITORIUM")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AUDITORIUM_ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="NUMBER_OF_SEATS")
    private int numberOfSeats;
    @Column(name="SEATS")
    @ElementCollection(targetClass=String.class)
    private Set<String> seats = Collections.emptySet();
    @Column(name="VIP_SEATS")
    @ElementCollection(targetClass=String.class)
    private Set<String> vipSeats = Collections.emptySet();
    public Auditorium() {};
    public Auditorium(Long id, String name, Set<String> seats, Set<String> vipSeats ) {
        this.id = id;
        this.name = name.toLowerCase();
        this.numberOfSeats = seats.size();
        this.seats = seats;
        this.vipSeats = vipSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name.toLowerCase();
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Set<String> getSeats() {
        return seats;
    }

    public void setSeats(Set<String> seats) {
        this.seats = seats;
    }

    public Set<String> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(Set<String> vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
        Auditorium other = (Auditorium) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (numberOfSeats != other.numberOfSeats) {
                return false;
        }
        return true;
    }

}
