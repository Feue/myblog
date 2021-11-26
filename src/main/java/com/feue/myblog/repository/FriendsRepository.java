package com.feue.myblog.repository;

import com.feue.myblog.model.FriendsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-25 10:01
 */
public interface FriendsRepository extends JpaRepository<FriendsDO, Long> {
    @Query(value = "select f.friendId\n" +
            "from friends f\n" +
            "where f.userId = :userId\n" +
            "and f.deleteTime is null")
    List<Long> findFriendIdsByUserId(Long userId);
}
