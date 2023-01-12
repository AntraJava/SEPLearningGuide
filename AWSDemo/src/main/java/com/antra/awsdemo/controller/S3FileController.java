package com.antra.awsdemo.controller;

import com.antra.awsdemo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class S3FileController {

    @Autowired
    S3Service s3Service;


    @GetMapping("/file/{fileName}")
    public void getFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        InputStream is = s3Service.downloadFile(fileName);
        FileCopyUtils.copy(is, response.getOutputStream());
    }

    @PostMapping("/file")
    public String uploadFile(@RequestParam("file") MultipartFile request) throws IOException {
        String key = UUID.randomUUID().toString();
        s3Service.uploadFile(key, request);
        return key;
    }

    //exception handler
}
