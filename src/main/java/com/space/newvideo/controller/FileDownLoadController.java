package com.space.newvideo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class FileDownLoadController implements ServletContextAware {
    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @ResponseBody
    @RequestMapping(value = "file/download/{filename}", method = RequestMethod.GET)
    public void downloadFile(@PathVariable String filename, HttpServletResponse response) {
//        String path = servletContext.getRealPath("/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        File file = new File("F://downServer", filename);
        response.setContentLengthLong(file.length());
        FileInputStream in = null;
        ServletOutputStream out = null;
        try {
            //下载显示的文件名，解决中文名称乱码问题
            String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
            response.setHeader("Content-Disposition", "attachment;fileName=" + downloadFielName);
            in = new FileInputStream(file);
            out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len=0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
