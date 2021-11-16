package com.feue.myblog.repository;

import com.feue.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Feue
 * @create 2021-11-16 13:55
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);
}
