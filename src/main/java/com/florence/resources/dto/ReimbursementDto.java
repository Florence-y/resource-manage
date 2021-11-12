package com.florence.resources.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报销
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReimbursementDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 报销用户的ID
     */
    private Long userId;

    /**
     * 报销类型
     */
    private Integer reimbursementType;

    /**
     * 报销的具体事宜
     */
    private String event;

    /**
     * 支付的方式
     */
    private Integer payWay;

    /**
     * 支付方式的信息
     */
    private String payDetail;


    /**
     * 操作这个资源的用户ID
     */
    private String userNumber;

    /**
     * 证明材料的具体信息
     */
    private String proveDetail;
    /**
     * 具体的开始时间点
     */
    private LocalDateTime eventStartTime;


    /**
     * 审核状态
     */
    private Integer status;

}
