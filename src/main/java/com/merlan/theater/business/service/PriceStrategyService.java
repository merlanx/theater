package com.merlan.theater.business.service;

/**
 * @author meilan xie
 */

import com.merlan.theater.business.domain.EventRating;
import com.merlan.theater.data.entity.Ticket;
import com.merlan.theater.data.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Service
public class PriceStrategyService {

    /**
     * Apply basic discount (PricingStrategy) to a ticket
     * @param ticket ticket
     * @return discount value from 1 to 100
     */
    public Double applyBasicPricingStrategy(@Nonnull Ticket ticket) {
        return ticket.getEvent().getBasePrice() * this.getPricingStrategyBySeat(ticket) *  this.getPricingStrategyByRating(ticket.getEvent().getRating());
    }
    /**
     * Apply user discount to a ticket
     * @param ticket ticket that a user is going to buy
     * @return discount value from 0 to 100
     */
    public Double applyUserPricingStrategy(@Nonnull Ticket ticket) {
        return ticket.getPrice() * this.getPricingStrategyByUser(ticket.getUser());
    }
    /**
     * Getting discount based on rating
     * @param eventRating eventRating of an event
     * @return discount value from 1 to 100
     */
    public @Nonnull Double getPricingStrategyByRating(@Nullable EventRating eventRating) {
        return 1.00;
    }

    /**
     * Getting discount based on seat and Auditorium
     * @param ticket ticket that assigned seat and auditorium
     * @return discount value from 1 to 100
     */
    public @Nonnull Double getPricingStrategyBySeat(@Nonnull Ticket ticket) {
        return 1.00;
    }

    /**
     * Getting discount based on some rules for user that buys some number of
     * tickets and birthday
     * @param user User that buys tickets. Can be <code>null</code>
     * @return discount value from 0 to 100
     */
    public @Nonnull Double getPricingStrategyByUser(@Nonnull User user) {
        return 1.00;
    }

}
