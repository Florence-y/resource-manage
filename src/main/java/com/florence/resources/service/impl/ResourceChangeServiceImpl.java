package com.florence.resources.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.florence.resources.mapper.ResourceChangeMapper;
import com.florence.resources.po.ResourceChange;
import com.florence.resources.service.IResourceChangeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物资装填 服务实现类
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Service
public class ResourceChangeServiceImpl extends ServiceImpl<ResourceChangeMapper, ResourceChange> implements IResourceChangeService {

}
