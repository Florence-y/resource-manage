package com.florence.resources.po;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课室申请
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClassroomPresentRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 想要申请教室的ID
     */
    private Long classId;

    /**
     * 申请的用户ID
     */
    private Long userId;

    /**
     * 申请的事宜描述
     */
    private String description;

    /**
     * 具体的开始时间点
     */
    private LocalDateTime presentDay;

    /**
     * 具体的开始时间点
     */
    private Integer startTime;

    /**
     * 具体的结束时间点
     */
    private Integer endTime;

    /**
     * 证明材料类型
     */
    private Integer proveType;

    /**
     * 证明材料的具体信息
     */
    private String proveDetail;


}
