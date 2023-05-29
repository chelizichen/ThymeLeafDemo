package com.example.demo.controller;

import com.example.demo.pojo.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("del")
    public Integer delOneById(@RequestParam("id")String id){
        return 1;
    }

    @GetMapping("update")
    public String update(@RequestParam(value = "id",defaultValue = "")String id,Model model){
        if(id.equals("")){

        }
        return "group/add";
    }

    @GetMapping("list")
    public String getList(@RequestParam(value = "page",defaultValue = "0")String page,
                          @RequestParam(value = "keyword",defaultValue = "")String keyword,
                          Model model){
        List<Group> list = groupService.getList(page, keyword);
        System.out.println(list);
        model.addAttribute("GroupList",list);
        return "group/list";
    }
}
