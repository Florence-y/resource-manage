package com.florence.resources.po;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课室
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课室名
     */
    private String name;

    /**
     * 课室大位置
     */
    private Integer locationFirst;

    /**
     * 课室小位置
     */
    private Integer locationSecond;

    /**
     * 容量
     */
    private Integer capacity;


}
