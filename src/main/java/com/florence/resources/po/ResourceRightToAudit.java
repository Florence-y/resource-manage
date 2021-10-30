package com.florence.resources.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class ResourceRightToAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 可以审核资源的用户ID
     */
    private Long userId;

    /**
     * 资源
     */
    private Long resourceId;


}
