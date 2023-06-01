package com.example.demo.mapper;

import com.example.demo.pojo.Player;
import com.example.demo.pojo.Team;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface TeamMapper {
    @Select("select * from team where t_name like #{keyword}")
    List<Team> getList(@Param("keyword")String keyword);
    @Delete("delete from team where id = #{id}")
    void del(@Param("id")String id);
    @Update("update team set t_name = #{t_name},country = #{county},coach = #{coach} where id = #{id}")
    void modify(Team team);
    @Insert("insert into team(t_name,country,coach) values  (#{t_name},#{country},#{coach})")
    void add(Team team);
    @Select("select * from player where team_id = ${id}")
    Optional<List<Player>> getCount(@Param("id")String id);
}
