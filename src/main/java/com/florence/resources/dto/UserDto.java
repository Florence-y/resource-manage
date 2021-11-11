package com.florence.resources.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户
     */
    private String name;

    /**
     * 用户的角色
     */
    private Integer role;

    /**
     * 学院
     */
    private String department;

    /**
     * 专业
     */
    private String major;

    /**
     * 学号或教师号
     */
    private String number;

    /**
     * 头像
     */
    private String avatar;
}
