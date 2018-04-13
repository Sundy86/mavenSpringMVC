package com.sc.controller;

import com.sc.utils.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller //告诉DispatcherServlet相关的容器， 这是一个Controller，
@RequestMapping(value="/hello")  //类级别的RequestMapping，告诉DispatcherServlet由这个类负责处理以及URL。HandlerMapping依靠这个标签来工作
public class HelloController {
    @Autowired
    private ServletContext servletContext;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
    private static Log log = new Log(HelloController.class);

    @RequestMapping(value="/mvc",method= RequestMethod.GET)
    public String HelloWorld(HttpServletRequest reques){

        reques.setAttribute("message","Hello Spring MVC!!!");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("message", "Hello Spring MVC!!!");

       // model.addAttribute("message","Hello Spring MVC!!!");  //传参数给前端

        //视图渲染，/WEB-INF/view/HelloWorld.jsp
        return "HelloWorld";  //页面的名称，根据此字符串会去寻找名为HelloWorld.jsp的页面
    }

    //定位到上传文件界面 /hello/upload
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String showUploadPage(){
        return "uploadFile";		 //上传单个文件
    }

    /**
     * 上传单个文件操作
     * @param multi
     * @return
     */
    @RequestMapping(value="/doUpload", method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file){

        if(!file.isEmpty()){
            log.debug("Process file: {}"+file.getOriginalFilename());
            try {

                String uploadPath = servletContext.getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
                //这里将上传得到的文件保存至服务器的指定目录
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadPath,
                        System.currentTimeMillis()+ file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e.toString());
            }
        }

        return "success";
    }

    //定位到上传多个文件界面 /hello/uploadMulti
    @RequestMapping(value="/uploadMulti", method=RequestMethod.GET)
    public String showUploadPage2(){
        return "uploadMultifile";		 //view文件夹下的上传多个文件的页面
    }


    /**
     * 上传多个附件的操作类
     * @param multiRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/doMultiUpload", method=RequestMethod.POST)
    public String doUploadFile2(MultipartHttpServletRequest multiRequest) throws IOException{

        Iterator<String> filesNames = multiRequest.getFileNames();
        while(filesNames.hasNext()){
            String fileName =filesNames.next();
            MultipartFile file =  multiRequest.getFile(fileName);
            if(!file.isEmpty()){
                log.debug("Process file: {}"+file.getOriginalFilename());
                String uploadPath = servletContext.getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadPath,
                        System.currentTimeMillis()+ file.getOriginalFilename()));
            }

        }

        return "success";
    }

}
