package com.merlan.theater.business.service;


import com.merlan.theater.data.entity.User;
import com.merlan.theater.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
     * @param user the user
     */
  public void saveUser(@Nonnull User user){
        if(userRepository.findByEmail(user.getEmail()) == null) {
            userRepository.save(user);
        } else {
            userRepository.saveUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthday(), user.getNumberOfTickets());
        }
    }
    /**
     * Remove a user
     * @param email Email of the user
     * @return removed user or empty
     */
    public @Nullable User removeUser(@Nonnull String email){
        User user = userRepository.findByEmail(email);
        if(user != null) {
            userRepository.delete(user);
        }
        return user;
    }
    /**
     * Remove a user
     * @param userId Id of the user
     * @return removed user or empty
     */
    public @Nullable User removeUser(@Nonnull Long userId){
        User user = userRepository.findByUserId(userId);
        if(user != null) {
            userRepository.delete(user);
        }
        return user;
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
    public @Nullable List<User> getUserByEmail(@Nonnull String ...emails){
        List<String> emailList = Arrays.asList(emails);
        return userRepository.findByEmails(emailList);
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
