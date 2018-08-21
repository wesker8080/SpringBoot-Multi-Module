package com.eliteai.et8080.mapper;

import com.eliteai.et8080.model.Node;

public interface NodeMapper {
    int deleteByPrimaryKey(Integer nodeId);

    int insert(Node record);

    int insertSelective(Node record);

    Node selectByPrimaryKey(Integer nodeId);

    int updateByPrimaryKeySelective(Node record);

    int updateByPrimaryKey(Node record);
}