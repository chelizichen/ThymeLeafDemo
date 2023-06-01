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

    public List<Team> getList( String keyword){
        keyword = "%" + keyword +"%";
        List<Team> list = groupMapper.getList(keyword);
        return list;
    }

    public Integer add(Team team){
        groupMapper.add(team);
        return 1;
    }

    public Integer modify(Team group){
        groupMapper.modify(group);
        return 1;
    }

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
