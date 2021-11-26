package com.feue.myblog.repository;

import com.feue.myblog.model.FriendRequestDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-25 12:44
 */
public interface FriendRequestRepository extends JpaRepository<FriendRequestDO, Long> {
    FriendRequestDO findByUserIdAndFriendId(Long userId, Long friendId);
    List<FriendRequestDO> findByFriendId(Long friendId);
}
