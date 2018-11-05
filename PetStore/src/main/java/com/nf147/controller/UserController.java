package com.nf147.controller;

import com.nf147.dao.UserMapper;
import com.nf147.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/go")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(User user){
        int u = userMapper.insert(user);
        return "";
    }

    @GetMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request){
        int a = userMapper.login(username,password);
        if(a>0) {
            request.getSession().setAttribute("username",username);
            return "{\"msg\":\"ok\"}";
        }
        else
            return "{\"msg\":\"no\"}";
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
