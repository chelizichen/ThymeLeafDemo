package com.example.demo.controller;

import com.example.demo.pojo.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    private GroupService groupService;


    @GetMapping("update")
    public String update(@RequestParam(value = "id",defaultValue = "")String id,Model model){
        model.addAttribute("id",id);
        return "group/update";
    }

    @PostMapping("add")
    @ResponseBody
    public Integer add(@RequestBody Group group){
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date());
        group.createTime = timeStamp;
        Integer add = groupService.add(group);
        return add;
    }

    @PostMapping("modify")
    @ResponseBody
    public Integer modify(@RequestBody Group group){
        Integer add = groupService.modify(group);
        return add;
    }

    @GetMapping("del")
    @ResponseBody
    public Integer delOneById(@RequestParam("id")String id){
        Integer del = groupService.del(id);
        return del;
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
