package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.entity.TTraining;
import com.wujiabo.fsd.entity.TTrainingCriteria;
import com.wujiabo.fsd.entity.TUserTraining;
import com.wujiabo.fsd.entity.TUserTrainingCriteria;
import com.wujiabo.fsd.mapper.TTrainingMapper;
import com.wujiabo.fsd.mapper.TUserTrainingMapper;
import com.wujiabo.fsd.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TTrainingMapper tTrainingMapper;
    @Autowired
    private TUserTrainingMapper tUserTrainingMapper;
    @Override
    public List<TTraining> findAllTrainings() {
        TTrainingCriteria example = new TTrainingCriteria();
        return tTrainingMapper.selectByExample(example);
    }

    @Override
    public List<TTraining> findEnableTrainings() {
        TTrainingCriteria example = new TTrainingCriteria();
        example.createCriteria().andStatusNotEqualTo("completed");
        return tTrainingMapper.selectByExample(example);
    }

    @Override
    public List<TTraining> findMyTrainings(String status, String email) {
        TUserTrainingCriteria userExample = new TUserTrainingCriteria();
        userExample.createCriteria().andUserNameEqualTo(email).andStatusEqualTo(status);
        List<TUserTraining> tUserTrainings = tUserTrainingMapper.selectByExample(userExample);
        List<String> trainingIds = tUserTrainings.stream().map(tUserTraining -> tUserTraining.getTrainingId()).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(trainingIds)){
            return Collections.EMPTY_LIST;
        }
        TTrainingCriteria example = new TTrainingCriteria();
        example.createCriteria().andIdIn(trainingIds);
        List<TTraining> tTrainings = tTrainingMapper.selectByExample(example);
        return tTrainings;
    }
}
