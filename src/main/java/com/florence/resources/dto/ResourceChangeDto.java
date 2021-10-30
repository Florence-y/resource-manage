package com.florence.resources.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 物资装填
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceChangeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作这个资源的用户ID
     */
    private Long userId;

    /**
     * 资源对应的ID
     */
    private Long resourceId;

    /**
     * 资源去向或者增加描述
     */
    private String description;

    /**
     * 资源的改变的数量
     */
    private Integer changeAmount;

    /**
     * 有效期开始时间
     */
    private LocalDateTime operateTime;

    /**
     * 审核的状态 0：未审核 1：批准 3 ：拒绝
     */
    private Integer status;

    /**
     * 审核描述
     */
    private String statusDescription;


}
