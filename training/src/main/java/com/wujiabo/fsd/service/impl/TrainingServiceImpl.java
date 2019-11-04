package com.wujiabo.fsd.service.impl;

import com.wujiabo.fsd.dto.TTechnology;
import com.wujiabo.fsd.dto.TUser;
import com.wujiabo.fsd.entity.TTraining;
import com.wujiabo.fsd.entity.TTrainingCriteria;
import com.wujiabo.fsd.entity.TUserTraining;
import com.wujiabo.fsd.entity.TUserTrainingCriteria;
import com.wujiabo.fsd.feign.TechnologyFeign;
import com.wujiabo.fsd.feign.UserFeign;
import com.wujiabo.fsd.mapper.TTrainingMapper;
import com.wujiabo.fsd.mapper.TUserTrainingMapper;
import com.wujiabo.fsd.service.TrainingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TTrainingMapper tTrainingMapper;
    @Autowired
    private TUserTrainingMapper tUserTrainingMapper;
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private TechnologyFeign technologyFeign;
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
    public List<TTraining> findUserTrainings(String status, String email) {
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

    @Override
    @Transactional
    public String bookTraining(String id, String email) {
        TUserTrainingCriteria userExample = new TUserTrainingCriteria();
        userExample.createCriteria().andUserNameEqualTo(email).andTrainingIdEqualTo(id);
        List<TUserTraining> tUserTrainings = tUserTrainingMapper.selectByExample(userExample);
        if(!CollectionUtils.isEmpty(tUserTrainings)){
            return "training is already booked";
        }
        ResponseEntity<TUser> responseEntity = userFeign.findByEmail(email);
        TUser tUser = responseEntity.getBody();
        TTraining tTraining = tTrainingMapper.selectByPrimaryKey(id);

        TUserTraining tUserTraining = new TUserTraining();
        tUserTraining.setId(UUID.randomUUID().toString());
        tUserTraining.setTrainingId(tTraining.getId());
        tUserTraining.setMentorId(tTraining.getMentorId());
        tUserTraining.setMentorName(tTraining.getMentorName());
        tUserTraining.setStatus("going");
        tUserTraining.setUserId(tUser.getId());
        tUserTraining.setUserName(tUser.getEmail());
        tUserTrainingMapper.insertSelective(tUserTraining);
        return "booked success";
    }

    @Override
    public List<TTraining> findMentorTrainings(String status, String email) {
        TTrainingCriteria example = new TTrainingCriteria();
        example.createCriteria().andMentorNameEqualTo(email).andStatusEqualTo(status);
        List<TTraining> tTrainings = tTrainingMapper.selectByExample(example);
        return tTrainings;
    }

    @Override
    @Transactional
    public String addTraining(TTraining tTraining) {

        ResponseEntity<TUser> responseEntity = userFeign.findByEmail(tTraining.getMentorName());
        TUser tUser = responseEntity.getBody();

        ResponseEntity<TTechnology> technologyResponseEntity = technologyFeign.findBySkillId(tTraining.getSkillId());
        TTechnology technology = technologyResponseEntity.getBody();

        tTraining.setId(UUID.randomUUID().toString());
        tTraining.setStatus("going");
        tTraining.setProgress(0);
        tTraining.setMentorId(tUser.getId());
        tTraining.setSkillName(technology.getSkillName());
        tTrainingMapper.insertSelective(tTraining);
        return "save success";
    }
}
