package com.gamgyuls.gamgyuls.repository;

import com.gamgyuls.gamgyuls.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(String email);
}
// Entity를 통해 db에 접근하는 역할