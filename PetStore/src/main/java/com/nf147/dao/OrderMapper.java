package com.nf147.dao;

import com.nf147.entity.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer order_id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer order_id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}