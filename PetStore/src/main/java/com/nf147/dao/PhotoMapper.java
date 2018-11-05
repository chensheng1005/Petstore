package com.nf147.dao;

import com.nf147.entity.Photo;
import java.util.List;

public interface PhotoMapper {
    int deleteByPrimaryKey(Integer photo_id);

    int insert(Photo record);

    Photo selectByPrimaryKey(Integer photo_id);

    List<Photo> selectAll();

    int updateByPrimaryKey(Photo record);
}