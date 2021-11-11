package com.florence.resources.controller;

import com.florence.resources.utils.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author wuyanzhen
 */
@RestController
@Slf4j
public class CommonController {


    @RequestMapping(value = "/upload",method = RequestMethod.POST,produces = "application/json")
    public String httpUpload(@RequestPart MultipartFile file){
            // 文件名
            String fileName = file.getOriginalFilename();
            String uploadFilePath = UploadUtils.getJarRootPath();
            File dest = new File(uploadFilePath +'/'+ fileName);
            try {
                file.transferTo(dest);
            } catch (Exception e) {
                log.error("文件转换失败",e);
                return "ERROR";
            }
        return fileName;
    }

}
