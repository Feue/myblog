package com.feue.myblog.service;

import com.feue.myblog.dto.FriendRequestDTO;
import com.feue.myblog.model.FriendRequestDO;
import com.feue.myblog.model.UserDO;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-25 10:02
 */
public interface FriendsService {
    List<UserDO> getFriendList(Long userId);

    List<FriendRequestDO> getFriendRequestByFriendId(Long friendId);

    void addFriend(Long userId, Long friendId);

    FriendRequestDO addFriendRequest(Long friendId);

    FriendRequestDO checkFriendRequest(FriendRequestDTO friendRequestDTO);
}
