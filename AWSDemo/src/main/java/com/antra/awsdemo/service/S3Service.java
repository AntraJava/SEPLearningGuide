package com.antra.awsdemo.service;

import java.io.IOException;
import java.io.InputStream;

public interface S3Service {
    InputStream downloadFile(String bucket, String key) throws IOException;
}
