package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestPart(value = "file") MultipartFile file) {
        System.out.println(file);
        // 处理图片上传逻辑
        // 在这里可以访问上传的文件并执行相应的操作，例如保存到服务器或数据库等
        try {
            String s = fileService.storeFile(file);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity("", HttpStatus.OK);
        // 返回响应
    }
}