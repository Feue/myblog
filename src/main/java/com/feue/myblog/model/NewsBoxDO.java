package com.feue.myblog.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Feue
 * @create 2021-11-24 16:58
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "news_box")
@Where(clause = "delete_time is null")
public class NewsBoxDO extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long newsId;
    private Long senderId;
    private Long receiverId;
    private Character like;
    private String comment;
}
