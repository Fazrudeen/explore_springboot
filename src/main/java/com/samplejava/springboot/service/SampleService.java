package com.samplejava.springboot.service;

import com.samplejava.springboot.model.UserRequest;
import com.samplejava.springboot.model.Users;
import com.samplejava.springboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    private static final Logger logger = LogManager.getLogger(SampleService.class);

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Users saveDB(UserRequest userRequest) throws Exception{
        Users users = new Users();
        users.setUserId(userRequest.getUserId());
        users.setFirstName(userRequest.getUserName());
        users.setLastName("Sheik Alawdeen");
        Users saveResult = null;
        if (!userRepository.existsByUserId(userRequest.getUserId())) {
            try {
                saveResult = userRepository.save(users);
                userRepository.flush();
            } catch (Exception e) {
                logger.info("Exception while updating DB");
                throw e;
            }
        }
        return saveResult;
    }

    public Users findUserByUserId(String userId) throws Exception {
        Users findResult = userRepository.findByUserId(userId);
        if (findResult == null) {
            throw new ResourceNotFoundException();
        }
        return findResult;
    }

    public List<Users> findUserByUserIds(List<String> userIds) throws Exception {
        return userRepository.findByUserIdIn(userIds);
    }

}
