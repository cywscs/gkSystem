package com.sdau.gksystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdau.gksystem.common.R;
import com.sdau.gksystem.mapper.CosultMapper;
import com.sdau.gksystem.pojo.cosult;
import com.sdau.gksystem.service.CosultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cosult")
public class CosultController {

    @Autowired
    CosultService cosultService;
    @Autowired
    CosultMapper cosultMapper;

    @GetMapping("/cosult/list")
    public R<List> page(int pageNum, int pageSize){

        Page pageInfo = new Page<>(pageNum, pageSize);
        cosultService.page(pageInfo);
        return R.success(pageInfo.getRecords(), pageInfo.getTotal());
    }


}
