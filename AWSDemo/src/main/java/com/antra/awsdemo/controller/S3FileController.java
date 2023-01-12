package com.antra.awsdemo.controller;

import com.antra.awsdemo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class S3FileController {

    @Autowired
    S3Service s3Service;

    @Value("${aws.app.bucket.file}")
    String bucket;

    @GetMapping("/file/{fileName}")
    public void getFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        InputStream is = s3Service.downloadFile(bucket, fileName);
        FileCopyUtils.copy(is, response.getOutputStream());
    }
}
