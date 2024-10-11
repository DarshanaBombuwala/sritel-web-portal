package com.sritel.user_service.repository;

import com.sritel.user_service.model.User;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String username);


   String getPasswordByUserName(String userName);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.userName = :username")
    int updateExistingPassword(@Param("password") String password, @Param("username") String username);
}
