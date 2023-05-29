package com.example.demo.controller;

import com.example.demo.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("player")
public class PlayerController {

    @GetMapping("del")
    public Integer delOneById(@RequestParam("id")String id){
        return 1;
    }

    @PostMapping("update")
    public Integer update(@RequestBody Player player){
        return null;
    }

    @GetMapping("list")
    public List<Player> getList(@RequestParam("page")String page,@RequestParam("keyword")String keyword,Model model){
        return null;
    }
}
