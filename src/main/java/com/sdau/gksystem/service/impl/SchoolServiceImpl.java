package com.sdau.gksystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdau.gksystem.mapper.SchoolMapper;
import com.sdau.gksystem.pojo.school;
import com.sdau.gksystem.service.SchoolService;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, school> implements SchoolService {
}
