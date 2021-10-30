package com.florence.resources.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class ResourceRightToAuditDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 可以审核资源的用户ID
     */
    private Long userId;

    /**
     * 资源
     */
    private Long resourceId;


}
