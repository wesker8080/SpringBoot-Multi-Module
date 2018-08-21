package com.eliteai.et8080.mapper;

import com.eliteai.et8080.model.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
}