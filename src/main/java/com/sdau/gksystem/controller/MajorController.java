package com.sdau.gksystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdau.gksystem.common.R;
import com.sdau.gksystem.mapper.MajorMapper;
import com.sdau.gksystem.mapper.SchoolMapper;
import com.sdau.gksystem.pojo.major;
import com.sdau.gksystem.pojo.school;
import com.sdau.gksystem.service.MajorService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/major")
public class MajorController {

    @Autowired
    MajorService majorService;
    @Autowired
    MajorMapper majorMapper;

    @GetMapping("/major/list")
    public R<List> page(int pageNum, int pageSize, String majorName, String argement, String category, String typee, String code){

        //构造分页构造器
        Page pageInfo = new Page(pageNum, pageSize);
        //构造条件构造器, 设置条件
        LambdaQueryWrapper<major> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(majorName), major::getMajorName, majorName);
        queryWrapper.eq(StringUtils.isNotEmpty(argement), major::getArgement, argement);
        queryWrapper.like(StringUtils.isNotEmpty(category), major::getCategory, category);
        queryWrapper.eq(StringUtils.isNotEmpty(code), major::getCode, code);

        //执行查询
        majorService.page(pageInfo, queryWrapper);
        return R.success(pageInfo.getRecords(), pageInfo.getTotal());
    }

    @GetMapping("/major/name/{name}")
    public R<major> majorByName(@PathVariable String name){
        LambdaQueryWrapper<major> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(major::getMajorName, name);
        return R.success(majorMapper.selectOne(lambdaQueryWrapper), 0);
    }

    @GetMapping("/major/{id}")
    public R<major> majorById(@PathVariable Integer id){
        return R.success(majorMapper.selectById(id), 0);
    }


}
