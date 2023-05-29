package com.example.demo.mapper;

import com.example.demo.pojo.Group;
import com.example.demo.pojo.Pagination;
import com.example.demo.pojo.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlayerMapper {
    List<Player> getList(@Param("keyword")String keyword,@Param("offset")Integer offset,@Param("size")Integer size);
    Integer delOne(@Param("id")String id);
    Integer update(Player player);
}
