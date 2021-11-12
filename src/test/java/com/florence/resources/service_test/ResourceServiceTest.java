package com.florence.resources.service_test;

import com.florence.resources.ResourcesApplication;
import com.florence.resources.dto.Page;
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
    public void addResource() {
        for (int i = 0; i < 10; i++) {
            Resource resource = new Resource();
            resource.setAmount(100L);
            resource.setType(0);
            resource.setDescription("用于社团开展活动");
            resource.setEffectStartTime(LocalDateTime.now());
            resource.setEffectEndTime(LocalDateTime.now().plusDays(7));
            resource.setUserId(1L);
            resource.setName("音响");
            service.save(resource);
        }
        for (int i = 0; i < 10; i++) {
            Resource resource = new Resource();
            resource.setAmount(100L);
            resource.setDescription("用于组织开会缺人的时候");
            resource.setType(1);
            resource.setEffectStartTime(LocalDateTime.now());
            resource.setEffectEndTime(LocalDateTime.now().plusDays(7));
            resource.setUserId(1L);
            resource.setName("椅子");
            service.save(resource);
        }

    }

    @Test
    public void testPage() {
        Page<Resource> resourcePage = new Page<>(2L, 2L);
        service.page(resourcePage);
        for (Resource resource : resourcePage.getRecords()) {
            System.out.println(resource);
        }
    }
}
