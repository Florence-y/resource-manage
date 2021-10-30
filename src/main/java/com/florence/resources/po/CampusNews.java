package com.florence.resources.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 校园新闻
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CampusNews implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户
     */
    private String name;

    /**
     * 图片的url
     */
    private String imgUrl;

    /**
     * 跳转的url
     */
    private String forwardUrl;


}
