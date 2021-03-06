package com.florence.resources.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.florence.resources.common.reply.ResponseStat;
import com.florence.resources.common.reply.ResponseStatHelper;
import com.florence.resources.dto.Page;
import com.florence.resources.dto.ResourceChangeDto;
import com.florence.resources.po.Resource;
import com.florence.resources.po.ResourceChange;
import com.florence.resources.po.User;
import com.florence.resources.service.IResourceChangeService;
import com.florence.resources.service.IResourceService;
import com.florence.resources.service.IUserService;
import com.florence.resources.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
@Slf4j
public class ResourceChangeController {


    @Autowired
    IResourceChangeService resourceChangeService;

    @Autowired
    IResourceService resourceService;
    
    @Autowired
    IUserService userService;

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


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    Page<ResourceChangeDto> list(Page<ResourceChange> page, HttpServletRequest request) {
        QueryWrapper<ResourceChange> condition = new QueryWrapper<>();
        condition.eq("user_Id", SessionUtil.getSessionAttribute(request, "userId"));
        resourceChangeService.page(page, condition);
        Page<ResourceChangeDto> pageDto = new Page<>();
        BeanUtils.copyProperties(page, pageDto);
        List<ResourceChangeDto> resourceChangeDtos = new ArrayList<>();
        //po转化dto
        page.getRecords().forEach((recode) -> {
            ResourceChangeDto resourceChangeDto = poConvert(recode);
            //设置请求者学号
            resourceChangeDto.setUserNumber((String) SessionUtil.getSessionAttribute(request, "number"));
            resourceChangeDtos.add(resourceChangeDto);
        });
        pageDto.setRecords(resourceChangeDtos);
        return pageDto;
    }


    @RequestMapping(value = "/listToExamine", method = RequestMethod.GET, produces = "application/json")
    Page<ResourceChangeDto> listToExamine(Page<ResourceChange> page, HttpServletRequest request,@RequestParam("status") Integer status){
        List<User> userList = userService.list();
        HashMap<Long, String> userIdMapNumber = new HashMap<>();
        userList.forEach((user -> {
            userIdMapNumber.put(user.getId(),user.getNumber());
        }));
        Object userId = SessionUtil.getSessionAttribute(request, "userId");
        if (Objects.isNull(userId)){
            log.error("未登录");
        }
        QueryWrapper<Resource> resourceCondition = new QueryWrapper<>();
        resourceCondition.eq("user_id",userId);

        List<Resource> list = resourceService.list(resourceCondition);
        List<Long> resourceIds = list.stream().map(Resource::getId).collect(Collectors.toList());
        if (!resourceIds.isEmpty()){
            QueryWrapper<ResourceChange> resourceChangeCondition = new QueryWrapper<>();
            resourceChangeCondition.in("resource_id",resourceIds);
            if (!Objects.isNull(status)){
                resourceChangeCondition.eq("status",status);
            }
            resourceChangeService.page(page,resourceChangeCondition);
        }
        //任何资源不属于他
        else{
            return new Page<>(page.getCurrent(),page.getSize());
        }

        Page<ResourceChangeDto> pageDto = new Page<>();
        BeanUtils.copyProperties(page, pageDto);
        List<ResourceChangeDto> resourceChangeDtos = new ArrayList<>();
        //po转化dto
        page.getRecords().forEach((recode) -> {
            ResourceChangeDto resourceChangeDto = poConvert(recode);
            //设置请求者学号
            resourceChangeDto.setUserNumber(userIdMapNumber.get(resourceChangeDto.getUserId()));
            resourceChangeDtos.add(resourceChangeDto);
        });
        pageDto.setRecords(resourceChangeDtos);
        return pageDto;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    ResponseStat<ResourceChange> update(@RequestBody ResourceChange resourceChange, HttpServletRequest request) {
        boolean save = resourceChangeService.updateById(resourceChange);
        return save ? ResponseStatHelper.success("操作成功") : ResponseStatHelper.error("操作失败");
    }


    private ResourceChangeDto poConvert(ResourceChange recode) {
        ResourceChangeDto resourceChangeDto = new ResourceChangeDto();
        BeanUtils.copyProperties(recode, resourceChangeDto);
        String name = resourceService.getById(recode.getResourceId()).getName();
        resourceChangeDto.setResourceName(name);
        return resourceChangeDto;
    }
}
