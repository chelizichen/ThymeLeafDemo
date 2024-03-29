package com.example.demo.mapper;

import com.example.demo.pojo.Group;
import com.example.demo.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映射到GroupMapper.xml里面的文件
 */
@Mapper
@Repository
public interface GroupMapper {
    List<Group> getList(@Param("keyword")String keyword,@Param("offset")Integer offset,@Param("size")Integer size);
    void del(@Param("id")String id);
    void modify(Group group);
    void add(Group group);
    List<Integer> getCount(@Param("id")String id);
}
