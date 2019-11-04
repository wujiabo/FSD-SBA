package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.entity.TTechnology;
import com.wujiabo.fsd.entity.TTechnologyCriteria;
import com.wujiabo.fsd.mapper.TTechnologyMapper;
import com.wujiabo.fsd.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TTechnologyMapper tTechnologyMapper;

    @Override
    public List<TTechnology> findAllTechnologies() {
        TTechnologyCriteria example = new TTechnologyCriteria();
        return tTechnologyMapper.selectByExample(example);
    }
}
