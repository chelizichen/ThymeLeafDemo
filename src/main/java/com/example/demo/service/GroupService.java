package com.example.demo.service;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.pojo.Group;
import com.example.demo.pojo.Pagination;
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
}
