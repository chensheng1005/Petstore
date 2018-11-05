package com.nf147.controller;

import com.nf147.dao.UserMapper;
import com.nf147.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.awt.ModalityListener;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }


    @PostMapping("/addUser")
    public String addUser(User user){
        int u = userMapper.insert(user);
        return "";
    }

    @GetMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        int a = userMapper.login(username,password);
        request.getSession().setAttribute("username",username);
        if(a>0) return "";
        else return "";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        return "";
    }

    @GetMapping("/selectName")
    public String selectName(String username, Model model){
        User user = userMapper.selectName(username);
        model.addAttribute("user",user);
        return "";
    }

    @PutMapping("/update")
    public String updateByName(User user){
        int u = userMapper.updateByName(user);
        if(u>0) return "";
        else return "";
    }

    @DeleteMapping("/del/{username}")
    public String del(@PathVariable("username") String username){
        int u = userMapper.deleteByName(username);
        if(u>0) return "";
        else return "";
    }
}
