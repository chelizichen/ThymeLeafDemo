package com.example.demo.controller;

import com.example.demo.config.Ret;
import com.example.demo.pojo.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    /**
     * MVC方法 跳转到用户修改或者添加界面
     */
    @GetMapping("update")
    public String update(@RequestParam(value = "id",defaultValue = "")String id,Model model){
        model.addAttribute("id",id);
        return "team_modify";
    }

    /**
     * 接口 添加用户
     */
    @PostMapping("add")
    @ResponseBody
    public Ret add(@RequestBody Team team){
        Integer add = teamService.add(team);
        return Ret.success(add);
    }
    /**
     * 接口 修改用户
     */
    @PostMapping("modify")
    @ResponseBody
    public Ret<Integer> modify(@RequestBody Team team){
        Integer modify = teamService.modify(team);
        return Ret.success(modify);
    }
    /**
     * 接口 删除用户
     */
    @GetMapping("del")
    @ResponseBody
    public Ret delOneById(@RequestParam("id")String id){
        Integer del = teamService.del(id);
        return Ret.success(del);
    }

    /**
     * MVC方法 查看用户
     */
    @GetMapping("list")
    public String getList(@RequestParam(value = "keyword",defaultValue = "")String keyword, Model model){
        List<Team> list = teamService.getList( keyword);
        System.out.println(list);
        model.addAttribute("teamList",list);
        return "list_team";
    }
}
