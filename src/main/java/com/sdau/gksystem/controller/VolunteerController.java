package com.sdau.gksystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdau.gksystem.common.R;
import com.sdau.gksystem.mapper.VolunteerMapper;
import com.sdau.gksystem.pojo.major;
import com.sdau.gksystem.pojo.school;
import com.sdau.gksystem.pojo.volunteer;
import com.sdau.gksystem.service.VolunteerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired
    VolunteerService volunteerService;
    @Autowired
    VolunteerMapper volunteerMapper;

    @GetMapping("/volunteer/list")
    public R<List> page(Integer pageNum, Integer pageSize, String majorName, String schoolName, String state, String category, String subject){

        Page pageInfo = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<volunteer> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(StringUtils.isNotEmpty(schoolName), volunteer::getSchoolName, schoolName);
        queryWrapper.like(StringUtils.isNotEmpty(majorName), volunteer::getMajorName, majorName);
        queryWrapper.eq(StringUtils.isNotEmpty(state), volunteer::getVolunteerBatch, state);
        queryWrapper.like(StringUtils.isNotEmpty(category), volunteer::getMajorName, category);
        queryWrapper.like(StringUtils.isNotEmpty(subject), volunteer::getVolunteerSubject, subject);
        volunteerService.page(pageInfo, queryWrapper);
        return R.success(pageInfo.getRecords(), pageInfo.getTotal());

    }
}
