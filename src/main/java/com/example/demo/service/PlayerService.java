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
    /*
    模糊查询球员
     */
    public List<Player> getList(String keyword){
        keyword = "%" + keyword +"%";
        System.out.println("keyword is " + keyword);
        List<Player> list = playerMapper.getList(keyword);
        return list;
    }
    /*
    添加球员
     */
    public Integer add(Player player){
        return playerMapper.add(player);
    }
    /*
    修改球员
     */
    public Integer modify(Player player){
        return playerMapper.modify(player);
    }
    /*
    删除球员
     */
    public Integer del(String id){
        return playerMapper.del(id);
    }
}
