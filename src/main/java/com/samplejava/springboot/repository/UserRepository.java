package com.samplejava.springboot.repository;

import com.samplejava.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>, JpaSpecificationExecutor {

    Boolean existsByUserId(String userId);

    Users findByUserId(String userId);

    List<Users> findByUserIdIn(List<String> userIds);

}