package com.feue.myblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author Feue
 * @create 2021-11-16 12:50
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Date createTime;
    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Date updateTime;
    @JsonIgnore
    private Date deleteTime;

}
