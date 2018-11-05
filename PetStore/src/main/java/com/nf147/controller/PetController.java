package com.nf147.controller;

import com.nf147.dao.PetMapper;
import com.nf147.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetMapper petMapper;

    @PostMapping("/add")
    public String insert(Pet pet){
        int a;
        a = petMapper.insert(pet);
        if(a>0)
            return "";
        else
            return "";
    }

    @PutMapping("/update")
    public String update(Pet pet){
        int a;
        a = petMapper.updateByPrimaryKey(pet);
        if(a>0)
            return "";
        else
            return "";
    }

    @GetMapping("/status")
    public String status(String status,Model model){
        List<Pet> list = petMapper.select_findByStatus(status);
        model.addAttribute("list",list);
        return "";
    }

    @GetMapping("/selectById/{id}")
    public String selectById(@PathVariable("id") int id,Model model){
        Pet pet = petMapper.selectByPrimaryKey(id);
        model.addAttribute("pet",pet);
        return "";
    }

    @DeleteMapping("/del/{id}")
    public String del(@PathVariable("id") int id){
        int d = petMapper.deleteByPrimaryKey(id);
        return "";
    }
}
