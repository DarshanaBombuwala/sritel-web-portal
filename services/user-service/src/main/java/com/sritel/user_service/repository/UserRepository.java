package com.sritel.user_service.repository;

import com.sritel.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String username);


   String getPasswordByUserName(String userName);

    Boolean updateExistingPassword(String newPassword);
}
