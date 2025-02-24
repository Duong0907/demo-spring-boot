package com.example.demo.image_upload;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUploadStrategy {
    Object uploadFile(MultipartFile file, String folderName);
    void removeFile(String publicId);
}
