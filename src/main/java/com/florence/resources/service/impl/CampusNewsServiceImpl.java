package com.florence.resources.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.florence.resources.mapper.CampusNewsMapper;
import com.florence.resources.po.CampusNews;
import com.florence.resources.service.ICampusNewsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 校园新闻 服务实现类
 * </p>
 *
 * @author Florence
 * @since 2021-10-30
 */
@Service
public class CampusNewsServiceImpl extends ServiceImpl<CampusNewsMapper, CampusNews> implements ICampusNewsService {

}
