package com.wd.Dao;

import com.wd.Enity.Content;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Content record);

    int insertSelective(Content record);

//    Content selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Content record);
//
//    int updateByPrimaryKeyWithBLOBs(Content record);
//
//    int updateByPrimaryKey(Content record);
}