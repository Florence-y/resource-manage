package com.florence.resources.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author wuyanzhen
 */
@Slf4j
public class UploadUtils {
    public static String getJarRootPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ").replace('/', '\\'));
        } catch (FileNotFoundException e) {
            log.error("获取当前运行目录失败", e);
        }
        if (!path.exists()) {
            path = new File("");
        }
        //如果上传目录为/static/img/，则可以如下获取：
        return path.getAbsolutePath();

    }
}
