package com.florence.resources.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 物资
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 拥有这个资源的用户ID
     */
    private Long userId;

    /**
     * 资源名
     */
    private String name;

    /**
     * 资源描述
     */
    private String description;


    /**
     * 图片描述
     */
    private String img;

    /**
     * 资源的数量
     */
    private Long amount;

    /**
     * 有效期开始时间
     */
    private LocalDateTime effectStartTime;

    /**
     * 有效期结束时间
     */
    private LocalDateTime effectEndTime;


}
