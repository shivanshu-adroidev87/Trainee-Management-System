package com.nucleus.project.service;

import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;

import java.util.List;

public interface TraineeService {
    Batch getBatchDetails(int traineeId);
    List<Assessment> getAssessmentsForTrainee(int traineeId);
}
