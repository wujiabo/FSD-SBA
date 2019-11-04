package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.dto.TTraining;
import com.wujiabo.fsd.feign.TrainingFeign;
import com.wujiabo.fsd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private TrainingFeign trainingFeign;

    @Override
    public List<TTraining> findAllCourse() {
        return trainingFeign.findAllCourse().getBody();
    }
}
