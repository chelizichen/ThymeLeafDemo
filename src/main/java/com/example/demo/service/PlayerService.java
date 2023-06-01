package com.example.demo.service;

import com.example.demo.mapper.PlayerMapper;
import com.example.demo.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    public List<Player> getList(String keyword){
        keyword = "%" + keyword +"%";
        System.out.println("keyword is " + keyword);
        List<Player> list = playerMapper.getList(keyword);
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
