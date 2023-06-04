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
// 根据分页和关键词查询球队函数
@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    // 删除函数
    @GetMapping("del")
    @ResponseBody
    public Integer del(@RequestParam("id")String id){
        return playerService.del(id);
    }

    // 添加函数
    @PostMapping("add")
    @ResponseBody
    public Integer add(@RequestBody Player player){
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());
        player.createTime = timeStamp;
        Integer add = playerService.add(player);
        return add;
    }
    // 修改球员接口
    @PostMapping("modify")
    @ResponseBody
    public Integer modify(@RequestBody Player player){
        Integer add = playerService.modify(player);
        return add;
    }

    // 修改或者添加球员的接口，对应跳转到MVC的路由中
    @GetMapping("update")
    public String update(@RequestParam(value = "id",defaultValue = "0") String id,Model model){
        model.addAttribute("id",id);
        return "player/update";

    }
    // 获取球队列表的MVC路由 对应template 下 Player/list
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
