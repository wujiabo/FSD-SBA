package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.entity.TTraining;
import com.wujiabo.fsd.entity.TTrainingCriteria;
import com.wujiabo.fsd.mapper.TTrainingMapper;
import com.wujiabo.fsd.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TTrainingMapper tTrainingMapper;
    @Override
    public List<TTraining> findAllTrainings() {
        TTrainingCriteria example = new TTrainingCriteria();
        return tTrainingMapper.selectByExample(example);
    }

    @Override
    public List<TTraining> findMyTrainings(String userId) {
        TTrainingCriteria example = new TTrainingCriteria();
        return tTrainingMapper.selectByExample(example);
    }
}
