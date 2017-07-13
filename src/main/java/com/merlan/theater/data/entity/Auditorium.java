package com.merlan.theater.data.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author meilan_xie
 */
@Entity
@Table(name="AUDITORIUM")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AUDITORIUM_ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="NUMBER_OF_SEATS")
    private long numberOfSeats;
    //@Column(data="VIP_SEATS")
    //private Set<Long> vipSeats = Collections.emptySet();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

   /* public Set<Long> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(Set<Long> vipSeats) {
        this.vipSeats = vipSeats;
    }
*/
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
        return true;
    }

}
