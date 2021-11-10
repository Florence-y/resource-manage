package com.florence.resources.service_test;

import com.florence.resources.ResourcesApplication;
import com.florence.resources.po.Resource;
import com.florence.resources.service.IResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = ResourcesApplication.class)
public class ResourceServiceTest {
    @Autowired
    IResourceService service;

    @Test
    public void addResource(){
        Resource resource = new Resource();
        resource.setAmount(100L);
        resource.setDescription("用于社团开展活动");
        resource.setEffectStartTime(LocalDateTime.now());
        resource.setEffectEndTime(LocalDateTime.now().plusDays(7));
        resource.setUserId(1L);
        resource.setName("音响");
        service.save(resource);
    }
}
