package com.sdau.gksystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdau.gksystem.mapper.MajorMapper;
import com.sdau.gksystem.mapper.VolunteerMapper;
import com.sdau.gksystem.pojo.major;
import com.sdau.gksystem.pojo.volunteer;
import com.sdau.gksystem.service.MajorService;
import com.sdau.gksystem.service.VolunteerService;
import org.springframework.stereotype.Service;


@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, volunteer> implements VolunteerService {
}
