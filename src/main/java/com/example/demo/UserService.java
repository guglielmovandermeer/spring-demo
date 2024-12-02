/**
 * Copyright @ 2019 by Hilti Corporation - all rights reserved
 */
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired private CrudRepository<UserEntity, Long> userRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(UserDto user) {
        userRepository.findById(user.getId())
                .ifPresent(dbUser -> doUpdate(user, dbUser));
    }

    private static void doUpdate(UserDto user, UserEntity dbUser) {
        dbUser.setEmail(user.getEmail());
    }

}
