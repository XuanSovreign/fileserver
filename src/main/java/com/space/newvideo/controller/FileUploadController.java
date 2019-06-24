package com.space.newvideo.controller;

import com.space.newvideo.bean.TestBean;
import com.space.newvideo.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value = "/upload")
public class FileUploadController {
    @ResponseBody
    @RequestMapping(value = "videoFile", method = RequestMethod.POST)
    public TestBean uploadFile(String userName, MultipartFile file) {
        TestBean bean = new TestBean();
        if (file.getSize() == 0) {
            bean.setCode(200);
            bean.setMessge("upload fail");
        }

        System.out.println("================" + userName);

        String filename = file.getOriginalFilename();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<" + filename);
        if (filename.contains("/")) {
            int index = filename.lastIndexOf("/");
            filename = filename.substring(index + 1);
            System.out.println("<<<<<<<<<<<<<substring<<<<<<<<" + filename);
        }
        try {
            FileUtil.uploadFile(file.getBytes(), "f://temp", filename);
            bean.setCode(100);
            bean.setMessge("upload success");
        } catch (Exception e) {
            e.printStackTrace();
            bean.setCode(200);
            bean.setMessge("upload fail");
        }
        return bean;
    }

    @RequestMapping(value = "file", method = RequestMethod.GET)
    public String test() {
        return "testupload";
    }

    @ResponseBody
    @RequestMapping(value = "testAndroid", method = RequestMethod.GET)
    public TestBean testAndroid() {
        TestBean bean = new TestBean();
        bean.setCode(100);
        bean.setMessge("hello world11");
        return bean;
    }

}
