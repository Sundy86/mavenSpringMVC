package com.sc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.utils.FileOperateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 文件的上传和下载
 *
 * @author zcq12
 *
 */
@Controller
public class FileOperateController {
    /**
     * 到上传文件的位置
     *
     * @author geloin
     * @date 2012-3-29 下午4:01:31
     * @return
     */
    @RequestMapping(value = "/to_upload")
    public String toUpload() {
        return "fileOperate/upload";
    }

    /**
     * 上传文件
     *
     * @author sundy
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileupload")
    public ModelAndView upload(HttpServletRequest request) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();

        // 别名
        String[] alaises = ServletRequestUtils.getStringParameters(request, "alais");

        String[] params = new String[] { "alais" };
        Map<String, Object[]> values = new HashMap<String, Object[]>();
        values.put("alais", alaises);

        List<Map<String, Object>> result = FileOperateUtil.upload(request, params, values);

        map.put("result", result);

        return new ModelAndView("fileOperate/list", map);
    }

    /**
     * 下载
     *
     * @author sundy
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/filedownload")
    public ModelAndView download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 下载源
        String storeName = request.getParameter("filename");
        System.out.println(storeName+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 下载之后的文件名
        String realName = "myPhoto.zip";
        String contentType = "application/octet-stream";

        FileOperateUtil.download(request, response, storeName, contentType, realName);

        return null;
    }
}