package com.florence.resources.service.impl;

import com.florence.resources.po.Resource;
import com.florence.resources.mapper.ResourceMapper;
import com.florence.resources.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物资 服务实现类
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
