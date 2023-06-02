package com.example.demo.mapper;

import com.example.demo.pojo.Player;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MYBatis 类
 */
@Mapper
@Repository
public interface PlayerMapper {

    @Select("select * from player  where p_name like #{keyword}")
    List<Player> getList(@Param("keyword")String keyword);

    @Delete("delete from player where id = #{id}")
    Integer del(@Param("id")String id);

    @Update("      update player set p_name = #{p_name},\n" +
            "  age = #{age},\n" +
            " nationality = #{nationality}\n" +
            " team_id = #{team_id},\n" +
            " img_src = #{img_src},\n" +
            "        where id = #{id}")
    Integer modify(Player player);

    @Insert("insert into player(p_name,age,nationality,team_id,img_src) values  (#{p_name},#{age},#{nationality},#{team_id},#{img_src})")
    Integer add(Player player);
}
