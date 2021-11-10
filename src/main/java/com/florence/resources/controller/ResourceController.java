package com.florence.resources.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.florence.resources.dto.Page;
import com.florence.resources.dto.ResourceDto;
import com.florence.resources.po.Resource;
import com.florence.resources.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * <p>
 * 物资 前端控制器
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {




    @Autowired
    IResourceService resourceService;


    @RequestMapping(value = "/list",produces = "application/json",method = RequestMethod.GET)
    Page<Resource> list(Page<Resource> page){
        resourceService.page(page);
        return page;
    }

    @RequestMapping(value = "/listByCondition",produces = "application/json",method = RequestMethod.GET)
     Page<Resource> listByCondition(Resource resource, @RequestParam("current") Long current, @RequestParam("size") Long size){
        Wrapper<Resource> resourceDtoQueryWrapper = new QueryWrapper<>(resource);
        Page<Resource> page = new Page<>(current, size);
        resourceService.page(page,resourceDtoQueryWrapper);
        return page;
    }
}
