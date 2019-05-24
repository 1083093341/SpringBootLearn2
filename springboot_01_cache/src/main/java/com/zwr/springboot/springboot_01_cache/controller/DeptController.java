package com.zwr.springboot.springboot_01_cache.controller;


import com.zwr.springboot.springboot_01_cache.bean.Department;
import com.zwr.springboot.springboot_01_cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @ResponseBody
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
    }
}
