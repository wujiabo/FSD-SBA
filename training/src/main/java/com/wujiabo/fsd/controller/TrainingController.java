package com.wujiabo.fsd.controller;

import com.wujiabo.fsd.entity.TTraining;
import com.wujiabo.fsd.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/enable/list")
    public ResponseEntity<List<TTraining>> findEnableTrainings() {
        List<TTraining> trainings = trainingService.findEnableTrainings();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/my/list/{status}/{email}")
    public ResponseEntity<List<TTraining>> findMyTrainings(@PathVariable("status") String status
            ,@PathVariable("email") String email) {
        List<TTraining> trainings = trainingService.findMyTrainings(status,email);
        return ResponseEntity.ok(trainings);
    }

    @PostMapping("/book/{id}/{email}")
    public ResponseEntity<String> bookTraining(@PathVariable("id") String id
            ,@PathVariable("email") String email) {
        String msg = trainingService.bookTraining(id,email);
        return ResponseEntity.ok(msg);
    }
}
