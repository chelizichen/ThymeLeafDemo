package com.example.demo.service;

import com.example.demo.mapper.TeamMapper;
import com.example.demo.pojo.Player;
import com.example.demo.pojo.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamMapper groupMapper;

    /*
    获得球队列表
     */
    public List<Team> getList( String keyword){
        keyword = "%" + keyword +"%";
        List<Team> list = groupMapper.getList(keyword);
        return list;
    }
    /*
    添加球队
     */
    public Integer add(Team team){
        groupMapper.add(team);
        return 1;
    }
    /*
    修改球队
     */
    public Integer modify(Team group){
        groupMapper.modify(group);
        return 1;
    }
    /*
     删除球队，如果球队有人，则不能删除
     */
    public Integer del(String id){
        Optional<List<Player>> count = groupMapper.getCount(id);
        if(count.isPresent()){
            List<Player> players = count.get();
            System.out.println(players.size());
            return 1;
        }else {
            del(id);
            return 0;
        }
    }
}
