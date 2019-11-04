package com.wujiabo.fsd.service;

import com.wujiabo.fsd.entity.TTraining;

import java.util.List;

public interface TrainingService {
    List<TTraining> findAllTrainings();

    List<TTraining> findEnableTrainings();
}
