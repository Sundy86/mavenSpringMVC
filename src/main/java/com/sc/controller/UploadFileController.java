package com.sc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/upload")
public class UploadFileController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/upload")
    public String showUpload() {
        return "uploadFile";
    }


    @RequestMapping(value = "/douploadSingle")
    public String uploadSingle(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            String filepath = servletContext.getRealPath("./") + File.separator + "upload";
            String filename = System.currentTimeMillis() + file.getOriginalFilename();
            System.out.println(filename+"---------------------");
            request.setAttribute("filename",filename);
          // file.transferTo(new File(filepath, filename));
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(filepath,filename));
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/multiupload", method = RequestMethod.GET)
    public String showMultiUpload() {
        return "uploadMultifile";
    }

    @RequestMapping(value = "/douploadMulti", method = RequestMethod.POST)
    public String uploadMultiFile(MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
        Iterator<String> filenames = multipartHttpServletRequest.getFileNames();
        while (filenames.hasNext()) {
            String filename = filenames.next();
            MultipartFile file = multipartHttpServletRequest.getFile(filename);
            if (!file.isEmpty()) {
                if (filename.endsWith("jpg") || filename.endsWith("png") || filename.endsWith("gif")) {
                    String filepath = servletContext.getRealPath("./") + File.separator + "upload";
                    file.transferTo(new File(filepath, filename));
                    // FileUtils.copyInputStreamToFile(file.getInputStream(),new File(filepath,filename));
                } else {
                    return "error";
                }
            }
        }
        return "success";
    }

    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model)throws Exception {
        //下载文件路径
        String path = servletContext.getRealPath("./")+ File.separator + "download";
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
