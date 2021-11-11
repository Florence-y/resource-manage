package com.florence.resources.controller;


import com.florence.resources.common.reply.ResponseStat;
import com.florence.resources.common.reply.ResponseStatHelper;
import com.florence.resources.po.ResourceChange;
import com.florence.resources.service.IResourceChangeService;
import com.florence.resources.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 物资装填 前端控制器
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@RestController
@RequestMapping("/resourceChange")
public class ResourceChangeController {


    @Autowired
    IResourceChangeService resourceChangeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    ResponseStat<ResourceChange> save(@RequestBody ResourceChange resourceChange, HttpServletRequest httpServletRequest) {
        Object userId = SessionUtil.getSessionAttribute(httpServletRequest, "userId");
        if (Objects.isNull(userId)) {
            return ResponseStatHelper.error("未登录");
        }
        resourceChange.setUserId((Long) userId);
        resourceChange.setOperateTime(LocalDateTime.now());
        Boolean save = resourceChangeService.save(resourceChange);
        if (save) {
            return ResponseStatHelper.success("请求资源成功,待审核");
        }
        return ResponseStatHelper.error("请求资源失败,请检查你的输入的数据");
    }

}
