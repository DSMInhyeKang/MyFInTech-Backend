package com.inhyekang.myfintech.repository;

import com.inhyekang.myfintech.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findBySub(String sub);
}
