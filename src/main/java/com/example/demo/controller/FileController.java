package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

// 文件上传接口
@Controller
@RequestMapping("file")
public class FileController {

    @Autowired
    FileService fileService;

    // 上传图片
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestPart(value = "file") MultipartFile file) {
        try {
            String s = fileService.storeFile(file);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("", HttpStatus.OK);
    }
}