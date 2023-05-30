package com.example.demo.controller;

import com.example.demo.pojo.Group;
import com.example.demo.pojo.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("del")
    @ResponseBody
    public Integer del(@RequestParam("id")String id){
        return playerService.del(id);
    }

    @PostMapping("add")
    @ResponseBody
    public Integer add(@RequestBody Player player){
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());
        player.createTime = timeStamp;
        Integer add = playerService.add(player);
        return add;
    }

    @PostMapping("modify")
    @ResponseBody
    public Integer modify(@RequestBody Player player){
        Integer add = playerService.modify(player);
        return add;
    }


    @GetMapping("update")
    public String update(@RequestParam("id") String id,Model model){
        model.addAttribute("id",id);
        return "player/update";

    }

    @GetMapping("list")
    public String getList(@RequestParam(value = "page",defaultValue = "0")String page,
                          @RequestParam(value = "keyword",defaultValue = "")String keyword,
                          Model model){
        List<Player> list = playerService.getList(page, keyword);
        System.out.println(list);
        model.addAttribute("PlayerList",list);
        return "player/list";
    }
}
