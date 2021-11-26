package com.feue.myblog.api.v1;

import com.feue.myblog.core.annotation.Authenticate;
import com.feue.myblog.dto.FriendRequestDTO;
import com.feue.myblog.model.FriendRequestDO;
import com.feue.myblog.model.UserDO;
import com.feue.myblog.service.FriendsService;
import com.feue.myblog.vo.FriendsVO;
import com.feue.myblog.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2021-11-25 10:03
 */
@RestController
@RequestMapping(value = "v1/friends")
public class FriendsController {
    @Autowired
    private FriendsService friendsService;

    @Authenticate
    @RequestMapping(value = "get/by/userId/{userId}", method = RequestMethod.GET)
    public UnifyResponse<FriendsVO> getAllByUserId(@PathVariable Long userId) {
        List<UserDO> userList = this.friendsService.getFriendList(userId);
        FriendsVO friendsVO = new FriendsVO(userList);
        return new UnifyResponse<>(friendsVO, "获取好友列表成功");
    }

    @Authenticate
    @RequestMapping(value = "add/friendId/{friendId}", method = RequestMethod.GET)
    public UnifyResponse<Object> addFriendByUserId(@PathVariable Long friendId) {
        FriendRequestDO result = this.friendsService.addFriendRequest(friendId);
        String message = result != null ? "好友请求发送成功" : "好友请求发送失败";
        return new UnifyResponse<>(message);
    }

    @Authenticate
    @RequestMapping(value = "request/by/friendId/{friendId}")
    private UnifyResponse<List<FriendRequestDO>> getFriendRequest(@PathVariable Long friendId) {
        List<FriendRequestDO> friendRequestList = this.friendsService.getFriendRequestByFriendId(friendId);
        return new UnifyResponse<>(friendRequestList, "获取好友申请列表成功");
    }

    @Authenticate
    @RequestMapping(value = "check/request", method = RequestMethod.POST)
    public UnifyResponse<Object> checkFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO) {
        FriendRequestDO friendRequestDO = this.friendsService.checkFriendRequest(friendRequestDTO);
        String message = "1".equals(friendRequestDTO.getState()) ? "接受好友请求" : "拒绝好友请求";
        if ("1".equals(friendRequestDTO.getState())) {
            this.friendsService.addFriend(friendRequestDO.getUserId(), friendRequestDO.getFriendId());
        }
        return new UnifyResponse<>(message);
    }
}
