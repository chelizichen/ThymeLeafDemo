package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    private static final String IMAGE_DIRECTORY = "D:chen\\dazuoye\\src\\main\\resources\\static\\img";
    public String storeFile(MultipartFile file) throws IOException {
        System.out.println();
        Path directory = Paths.get(IMAGE_DIRECTORY);
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = directory.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

}
