package com.wujiabo.fsd.controller;

import com.wujiabo.fsd.entity.TTraining;
import com.wujiabo.fsd.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/training")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @GetMapping("/list")
    public ResponseEntity<List<TTraining>> findAllCourse() {
        List<TTraining> trainings = trainingService.findAllTrainings();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/my/list")
    public ResponseEntity<List<TTraining>> findMyTrainings() {
        List<TTraining> trainings = trainingService.findMyTrainings("");
        return ResponseEntity.ok(trainings);
    }
}