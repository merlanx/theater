package com.merlan.theater.business.service;


import com.merlan.theater.data.entity.User;
import com.merlan.theater.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author meilan_xie
 */
@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    public @Nullable User getUserByEmail(@Nonnull String email){
        return null;
    }

}
