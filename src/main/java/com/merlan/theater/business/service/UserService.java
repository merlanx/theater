package com.merlan.theater.business.service;


import com.merlan.theater.data.entity.User;
import com.merlan.theater.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author meilan_xie
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * Save an user
     * @param firstName firstName of the user
     * @param lastName lastName of the user
     * @param email Email of the user
     * @param birthday Birthday of the user
     * @param boughtTickets total amount of tickets that the user bought
     * @return a updated/new user
     */
    public @Nullable User saveUser(@Nonnull String firstName, @Nullable String lastName, @Nonnull String email,@Nullable LocalDate birthday, @Nullable Integer boughtTickets){
        return null;
    }
    /**
     * Remove a user
     * @param email Email of the user
     * @param userId Id of the user
     * @return removed user or empty
     */
    public @Nullable User removeUser(@Nonnull String email, @Nullable String userId){
        return null;
    }
    /**
     * Finding all users
     * @return all users or <code>null</code>
     */
    public @Nullable Set<User> getAll(){return userRepository.findAll();}
    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserByEmail(@Nonnull String email){
        return userRepository.findByEmail(email);
    }

    /**
     * Finding user by id
     *
     * @param userId
     *            userId of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserById(@Nonnull Long userId){
        return userRepository.findByUserId(userId);
    }

}
