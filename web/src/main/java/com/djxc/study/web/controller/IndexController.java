package com.djxc.study.web.controller;

import com.djxc.study.demo.entity.DataEntity;
import com.djxc.study.demo.entity.EmailEntity;
import com.djxc.study.demo.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;

@RestController
@RequestMapping("/index")
public class IndexController {
    private final EmailService emailService;

    public IndexController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }

    @PostMapping("/email")
    public boolean sendEmail(@RequestBody EmailEntity emailEntity) {
        emailService.send(emailEntity);
        return true;
    }

    @RequestMapping("/oneFileUpload")
    private void oneFIleLoad(MultipartHttpServletRequest request, HttpServletResponse respose)
    {
        try{
            MultipartFile file = request.getFile("uoloadFile");
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            String targetDir = request.getSession().getServletContext().getRealPath("/upload");
            System.out.println(targetDir);
            File targetFile = new File(targetDir,fileName);
            FileOutputStream os = new FileOutputStream(targetFile);
            IOUtils.copy(is, os);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value="downloadFile", method=RequestMethod.POST)
    public void downloadFile(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            String filename = "杜杰.txt";
            String fileNameEncode = new String(filename.getBytes(), "ISO8859-1");
            response.setContentType("application/x-msdownload");
            FileInputStream is = new FileInputStream(new File(request.getSession().getServletContext().getRealPath("")+"/"+filename));
            response.setHeader("Content-Disposition", "attachment;filename="+fileNameEncode);
            OutputStream os = response.getOutputStream();
            IOUtils.copy(is, os);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @PostMapping("/newData")
    public String newData(@RequestBody DataEntity msg) {
        System.out.println(msg.getData());
        return "ok";
    }
}
