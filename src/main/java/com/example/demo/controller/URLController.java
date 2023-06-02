package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class URLController {

    @Autowired
    FileService fileService;

    // 上传图片的接口
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