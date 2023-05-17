package com.sdau.gksystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdau.gksystem.common.R;
import com.sdau.gksystem.mapper.SchoolMapper;
import com.sdau.gksystem.pojo.school;
import com.sdau.gksystem.service.SchoolService;
import com.sdau.gksystem.service.impl.SchoolServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private SchoolMapper schoolMapper;
    @GetMapping("/school/list")
    public R<List> page(int pageNum, int pageSize, String schoolName, String argement, String handleType, String city){

        //构造分页构造器
        Page pageInfo = new Page(pageNum, pageSize);
        //构造条件构造器, 设置条件
        LambdaQueryWrapper<school> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(schoolName), school::getSchoolName, schoolName);
        queryWrapper.eq(StringUtils.isNotEmpty(argement), school::getArgement, argement);
        queryWrapper.like(StringUtils.isNotEmpty(handleType), school::getHandleType, handleType);
        queryWrapper.like(StringUtils.isNotEmpty(city), school::getSchoolAddress, city);

        //执行查询
        schoolService.page(pageInfo, queryWrapper);
        return R.success(pageInfo.getRecords(), pageInfo.getTotal());
    }

    @GetMapping("/school/index/{id}")
    public R<school> schoolById(@PathVariable Integer id){
        return R.success(schoolMapper.selectById(id), 0);
    }

    @GetMapping("/school/name/{name}")
    public R<school> schoolByName(@PathVariable String name){
        LambdaQueryWrapper<school> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(school::getSchoolName, name);
        return R.success(schoolMapper.selectOne(lambdaQueryWrapper),0);
    }
}
