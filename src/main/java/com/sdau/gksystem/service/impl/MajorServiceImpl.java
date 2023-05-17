package com.sdau.gksystem.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdau.gksystem.mapper.MajorMapper;
import com.sdau.gksystem.mapper.SchoolMapper;
import com.sdau.gksystem.pojo.major;
import com.sdau.gksystem.pojo.school;
import com.sdau.gksystem.service.MajorService;
import com.sdau.gksystem.service.SchoolService;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, major> implements MajorService {
}
