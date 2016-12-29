package com.wd.CoilingDragon.Dao;

import com.wd.CoilingDragon.Enity.Catalogue;

public interface CatalogueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Catalogue record);

    int insertSelective(Catalogue record);

    Catalogue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catalogue record);

    int updateByPrimaryKey(Catalogue record);
}