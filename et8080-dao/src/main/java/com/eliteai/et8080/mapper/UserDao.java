package com.eliteai.et8080.mapper;

import com.eliteai.et8080.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {
    @Select("select * from  user ")
    List<User> selectAll();
}
