package com.antra.awsdemo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface S3Service {
    InputStream downloadFile(String key) throws IOException;

    void uploadFile(String key, MultipartFile request) throws IOException;
}
