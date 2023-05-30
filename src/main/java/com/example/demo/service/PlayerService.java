package com.example.demo.service;

import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.PlayerMapper;
import com.example.demo.pojo.Group;
import com.example.demo.pojo.Pagination;
import com.example.demo.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    public List<Player> getList(String page,String keyword){
        Pagination pagination = new Pagination(page, keyword);
        List<Player> list = playerMapper.getList(pagination.getKeyword(),pagination.getOffset(),pagination.getSize());
        return list;
    }

    public Integer add(Player player){
        return playerMapper.add(player);
    }

    public Integer modify(Player player){
        return playerMapper.modify(player);
    }

    public Integer del(String id){
        return playerMapper.del(id);
    }
}
