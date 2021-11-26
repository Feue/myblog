package com.feue.myblog.vo;

import com.feue.myblog.model.UserDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-11-25 10:14
 */
@Getter
@Setter
@NoArgsConstructor
public class FriendsVO {
    private List<Map<String, Object>> friends;

    public FriendsVO(List<UserDO> userList) {
        this.friends = new ArrayList<>();
        userList.forEach(user -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getId());
            map.put("nickname", user.getNickname());
            this.friends.add(map);
        });
    }
}
