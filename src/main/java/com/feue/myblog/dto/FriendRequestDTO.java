package com.feue.myblog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Feue
 * @create 2021-11-25 15:20
 */
@Getter
@Setter
@ToString
public class FriendRequestDTO {
    private Long id;
    private String state;
    private String comment;
}
