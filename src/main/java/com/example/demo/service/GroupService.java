package com.example.demo.service;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.pojo.Group;
import com.example.demo.pojo.Pagination;
import com.example.demo.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    public List<Group> getList(String page,String keyword){
        Pagination pagination = new Pagination(page, keyword);
        List<Group> list = groupMapper.getList(pagination.getKeyword(),pagination.getOffset(),pagination.getSize());
        return list;
    }

    public Integer add(Group group){
        groupMapper.add(group);
        return 1;
    }

    public Integer modify(Group group){
        groupMapper.modify(group);
        return 1;
    }

    public Integer del(String id){
        List<Integer> count = groupMapper.getCount(id);
        System.out.println("count is "+count);
        if(count.get(0) > 0){
            return 0;
        }
        groupMapper.del(id);
        return 1;
    }
}
