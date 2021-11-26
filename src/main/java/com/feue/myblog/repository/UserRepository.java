package com.feue.myblog.repository;

import com.feue.myblog.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-16 13:55
 */
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findOneById(Long id);
    UserDO findOneByNickname(String name);
    UserDO findOneByMobile(String account);
    UserDO findOneByEmail(String account);
}
