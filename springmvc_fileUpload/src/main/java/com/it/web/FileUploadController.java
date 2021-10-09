package com.it.web;

import com.it.utils.UploadUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
    // 测试文件上传要求
    @RequestMapping("/upload01")
    public String upload01(HttpServletRequest request ) throws IOException {
        // String desc = request.getParameter("desc");
        // String upload = request.getParameter("upload");
        // 一旦在表单里面加了 enctype="multipart/form-data" 使用getParameter() 获得的值就为null了, 使用流获得
        InputStream is = request.getInputStream();
        // 1.把is读取成字符串
        // 2.发现规律, 截取字符串
        // 3.把文件的内容 通过输出流 保存到文件里面
        System.out.println("upload01()");
        return "success";
    }

    // springmvc 传统方式文件上传
    @RequestMapping("/upload02")
    public String upload02(String desc, MultipartFile upload, HttpServletRequest request) throws IOException {
        System.out.println("文件的描述:" + desc);
        // 1.获得文件的名字
        String filename = upload.getOriginalFilename();
        System.out.println("文件名:" + filename);
        // 2.基于upload创建文件对象
        // 2.1获得upload绝对路径
        ServletContext servletContext = request.getSession().getServletContext();
        String realPath = servletContext.getRealPath("upload");
        //****************************
        // 2.2 文件重名(随机文件名)
        String uuidName = UploadUtils.getUUIDName(filename);

        // 2.3 两层目录  时间  2019/07/02/17/09/1
        String dir = UploadUtils.getDir();  // /A/B
        File fileDir = new File(realPath, dir);
        if(!fileDir.exists()){
            // 不存在 创建出来
            fileDir.mkdirs();
        }
        //****************************
        //2.4 基于filename创建file
        File file = new File(fileDir, uuidName);
        //3.上传
        upload.transferTo(file);
        return "success";
    }

    // springmvc 跨服务器文件上传
    @RequestMapping("/upload03")
    public String upload03(String desc, MultipartFile upload, HttpServletRequest request) throws IOException {
        String FILE_SERVER_URL = "http://localhost:9090/upload/";

        // 1.获得文件的名字
        String filename = upload.getOriginalFilename();
       // 2.改文件名为随机的
        String uuidName = UploadUtils.getUUIDName(filename);
        // 3.使用jersey API 进行跨服务器文件上传
        Client client = Client.create();
        WebResource resource = client.resource(FILE_SERVER_URL + uuidName);//文件服务器和文件名进行关联
        resource.put(upload.getBytes()); //把文件的内容进行上传, 和resource(包含文件名) 进行对应
        return "success";
    }
}
