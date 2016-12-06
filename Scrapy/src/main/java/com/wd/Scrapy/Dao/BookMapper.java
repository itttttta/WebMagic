package com.wd.Scrapy.Dao;

import com.wd.Scrapy.Enity.Book;

public interface BookMapper {
    int insert(Book record);

    int insertSelective(Book record);
}