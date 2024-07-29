package com.wuyanzu.controller;

import com.wuyanzu.pojo.Result;
import com.wuyanzu.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
   /* @PostMapping("/upload")
    //MultipartFile:springboot的文件对象
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}，{}，{}",username,age,image);
        //获取文件原始文件名
        String originalFilename = image.getOriginalFilename();
        //构造唯一的文件名
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName= UUID.randomUUID().toString()+extname;
        log.info("新的文件名：{}，"+newFileName);
        //将文件存放在：E:\JavaWeb编写文件\JavaWeb-workspace\tlias-web-management\images
        image.transferTo(new File("E:\\JavaWeb编写文件\\JavaWeb-workspace\\tlias-web-management\\images\\"+newFileName));
        return Result.success();

    }*/

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传:{}", image.getOriginalFilename());
        //调用阿里云oss对象存储工具
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件url为：{}", url);
        return Result.success(url);

    }
}
