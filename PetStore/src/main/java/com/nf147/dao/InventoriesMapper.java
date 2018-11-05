package com.nf147.dao;

import com.nf147.entity.Inventories;
import java.util.List;

public interface InventoriesMapper {
    int deleteByPrimaryKey(Integer inventories_id);

    int insert(Inventories record);

    Inventories selectByPrimaryKey(Integer inventories_id);

    List<Inventories> selectAll();

    int updateByPrimaryKey(Inventories record);
}