package com.nucleus.project.repo;

import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;

import java.util.List;

public interface TraineeRepo {
    Batch getBatchDetails(int traineeId);
    List<Assessment> getAssessmentsForTrainee(int traineeId);
}
