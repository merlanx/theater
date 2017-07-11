package com.merlan.theater.data.entity;

import com.merlan.theater.business.domain.EventPricingStrategy;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author meilan_xie */
@Entity
@Table(name="PRICING_STRATEGY")
public class PricingStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRICING_STRATEGY_ID")
    private long id;

    @Column(name="PRICING_STRATEGY")
    private EventPricingStrategy pricingStrategy;
    @Column(name="DISCOUNT")
    private double discount;

    @Override
    public int hashCode() {
        return Objects.hash(pricingStrategy, discount);
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
        PricingStrategy other = (PricingStrategy) obj;
        if (pricingStrategy == null) {
            if (other.pricingStrategy != null) {
                return false;
            }
        } else if (!pricingStrategy.equals(other.pricingStrategy)) {
            return false;
        }
        if (other.discount != discount) {
            return false;
        }

        return true;
    }

}
