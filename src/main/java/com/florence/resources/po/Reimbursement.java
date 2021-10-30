package com.florence.resources.po;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Reimbursement implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 证明材料类型
     */
    private Integer proveType;

    /**
     * 证明材料的具体信息
     */
    private String proveDetail;

    /**
     * 具体的开始时间点
     */
    private LocalDateTime eventStartTime;

    /**
     * 具体的结束时间点
     */
    private LocalDateTime eventEndTime;


}
