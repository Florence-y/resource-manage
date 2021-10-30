package com.florence.resources.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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


}
