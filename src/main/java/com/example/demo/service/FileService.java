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
    private static final String IMAGE_DIRECTORY = "D:\\chelizichen\\code\\ThymeleafDemo\\src\\main\\resources\\static\\img";

    public String storeFile(MultipartFile file) throws IOException {
        System.out.println();
        Path directory = Paths.get(IMAGE_DIRECTORY);

        // 如果目录不存在，则创建它
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        // 生成新的文件名，可以根据需要进行修改
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // 创建文件路径
        Path filePath = directory.resolve(fileName);

        // 将上传的文件保存到目标路径
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

}
