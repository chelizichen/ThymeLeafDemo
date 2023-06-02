package com.example.demo.controller;

import com.example.demo.config.Ret;
import com.example.demo.pojo.Player;
import com.example.demo.service.PlayerService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    /**
     * @param id
     * 删除球员
     */
    @GetMapping("del")
    @ResponseBody
    public Ret del(@RequestParam(defaultValue = "",value = "id")String id){
        return Ret.success(playerService.del(id));
    }
    /**
     * @param player
     * 添加球员
     */
    @PostMapping("add")
    @ResponseBody
    public Ret add(@RequestBody Player player){
        Integer add = playerService.add(player);
        return Ret.success(add);
    }
    /**
     * @param player
     * 修改球员
     */
    @PostMapping("modify")
    @ResponseBody
    public Ret modify(@RequestBody Player player){
        Integer add = playerService.modify(player);
        return Ret.success(add);
    }

    /**
     * MVC 方法 跳转到修改球员界面
     */
    @GetMapping("update")
    public String update(@RequestParam(defaultValue = "0",value = "") String id, Model model){
        model.addAttribute("id",id);
        return "player_modify";

    }
    /**
     * MVC 方法 跳转到球员列表
     */
    @GetMapping("list")
    public String getList(@RequestParam(value = "keyword",defaultValue = "")String keyword, Model model){
        List<Player> list = playerService.getList(keyword);
        System.out.println(list);
        model.addAttribute("PlayerList",list);
        return "list_player";
    }
}
