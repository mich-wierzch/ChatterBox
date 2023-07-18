package com.michwierzch.ChatterBox.repository;

import com.michwierzch.ChatterBox.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE UserModel a " +
            "SET a.enabled = TRUE WHERE a.username = ?1")
    int enableAppUser(String username);
}
