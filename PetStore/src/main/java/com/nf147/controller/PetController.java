package com.nf147.controller;

import com.google.gson.Gson;
import com.nf147.dao.CategoryMapper;
import com.nf147.dao.PetMapper;
import com.nf147.entity.Category;
import com.nf147.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private CategoryMapper categoryMapper;


    //查询所有的宠物
    @GetMapping(value = "/selectAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getPetMapper() {
        List<Pet> list = petMapper.selectAll();
        return new Gson().toJson(list);
    }

    //查询宠物的所有类型
    @GetMapping(value = "/selAllCategory",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCategory(){
        List<Category> list = categoryMapper.selectAll();
        return new Gson().toJson(list);
    }


    //宠物图片上传
    @PostMapping(value = "/image",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String image(@RequestPart("file") MultipartFile file,HttpServletRequest request){
        if (file.isEmpty()) {
            return "{\"false\":\"上传失败\"}";
        }
        if (!file.getContentType().contains("image/")) {
            return "{\"false\":\"上传失败\"}";
        }
        if (file.getSize() > 1024 * 1024 * 1024 * 5) {
            return "{\"false\":\"上传失败\"}";
        }

        //图片保存路径
        String tartPath;

        //获取项目根路径
        String basePath = request.getServletContext().getRealPath("/img");
        //获取图片名称
        String fileName = file.getOriginalFilename();
        tartPath = basePath+"/"+fileName;
        File file1 = new File(tartPath);
        if (file1.exists()){
            file1.mkdir();
        }
        String src;
        src = fileName;
        try {
            //如果文件夹不存在，创建新文件夹
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"false\":\"上传失败\"}";
        }
        return "{\"true\":\""+src+"\"}";
    }


    @PostMapping(value = "/add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insert(Pet pet){
        int a;
        a = petMapper.insert(pet);
        if(a>0)
            return "{\"msg\":\"success\"}";
        else
            return "{\"msg\":\"添加失败\"}";
    }

    @PostMapping(value = "/update",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(Pet pet){
        int a = petMapper.updateByPrimaryKey(pet);
        if(a>0)
            return "{\"msg\":\"success\"}";
        else
            return "{\"msg\":\"更新失败\"}";
    }

    @GetMapping("/status")
    public String status(String status,Model model){
        List<Pet> list = petMapper.select_findByStatus(status);
        model.addAttribute("list",list);
        return "";
    }

    @GetMapping(value = "/selectById",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectById(int id){
        Pet pet = petMapper.selectByPrimaryKey(id);
        return new Gson().toJson(pet);
    }

    @GetMapping(value = "/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String del(int petId){
        int d = petMapper.deleteByPrimaryKey(petId);
        if(d>0)
            return "{\"msg\":\"success\"}";
        else
            return "{\"msg\":\"删除失败\"}";
    }
}
