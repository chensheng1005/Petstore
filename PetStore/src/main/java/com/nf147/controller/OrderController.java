package com.nf147.controller;

import com.nf147.dao.OrderMapper;
import com.nf147.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/store")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/order")
    public String Orders(Order order){
        int o = orderMapper.insert(order);
        if(o>0) return "";
        else return "";
    }
    @GetMapping("/orderId/{id}")
    public String selectById(@PathVariable("id") int id, Model model){
        Order order = orderMapper.selectByPrimaryKey(id);
        model.addAttribute("order",order);
        return "";
    }

    @DeleteMapping("/del/{id}")
    public String del(@PathVariable("id") int id, Model model){
        int o = orderMapper.deleteByPrimaryKey(id);
        if(o>0) return "";
        else return "";
    }
}
