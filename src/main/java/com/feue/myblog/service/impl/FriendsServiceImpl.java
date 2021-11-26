package com.feue.myblog.service.impl;

import com.feue.myblog.core.LocalUser;
import com.feue.myblog.dto.FriendRequestDTO;
import com.feue.myblog.exception.ParameterException;
import com.feue.myblog.model.FriendRequestDO;
import com.feue.myblog.model.FriendsDO;
import com.feue.myblog.model.UserDO;
import com.feue.myblog.repository.FriendRequestRepository;
import com.feue.myblog.repository.FriendsRepository;
import com.feue.myblog.repository.UserRepository;
import com.feue.myblog.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-25 10:02
 */
@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendsRepository friendsRepository;
    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Override
    public List<UserDO> getFriendList(Long userId) {
        List<Long> friendIdList = this.friendsRepository.findFriendIdsByUserId(userId);
        return this.userRepository.findAllById(friendIdList);
    }

    @Override
    public List<FriendRequestDO> getFriendRequestByFriendId(Long friendId) {
        return this.friendRequestRepository.findByFriendId(friendId);
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
        FriendsDO friendsDO = FriendsDO.builder()
                .userId(userId)
                .friendId(friendId)
                .build();
        this.friendsRepository.save(friendsDO);
        friendsDO = FriendsDO.builder()
                .userId(friendId)
                .friendId(userId)
                .build();
        this.friendsRepository.save(friendsDO);
    }

    @Override
    public FriendRequestDO addFriendRequest(Long friendId) {
        Long userId = LocalUser.getUser().getId();
        FriendRequestDO exist = this.friendRequestRepository.findByUserIdAndFriendId(userId, friendId);
        if (exist != null) {
            throw new ParameterException(20006);
        }
        FriendRequestDO friendRequestDO = FriendRequestDO.builder()
                .userId(userId)
                .friendId(friendId)
                .build();
        return this.friendRequestRepository.save(friendRequestDO);
    }

    @Override
    public FriendRequestDO checkFriendRequest(FriendRequestDTO friendRequestDTO) {
        FriendRequestDO friendRequestDO = this.friendRequestRepository.getById(friendRequestDTO.getId());
        if (!"0".equals(friendRequestDO.getState())) {
            throw new ParameterException(10007);
        }
        friendRequestDO.setState(friendRequestDTO.getState());
        friendRequestDO.setComment(friendRequestDTO.getComment());
        return this.friendRequestRepository.save(friendRequestDO);
    }
}
