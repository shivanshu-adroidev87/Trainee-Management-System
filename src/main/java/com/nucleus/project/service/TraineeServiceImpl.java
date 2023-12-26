package com.nucleus.project.service;

import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;
import com.nucleus.project.repo.TraineeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepo traineeRepo;
    @Override
    public Batch getBatchDetails(int traineeId) {
        return traineeRepo.getBatchDetails(traineeId);
    }

    @Override
    public List<Assessment> getAssessmentsForTrainee(int traineeId) {
        return traineeRepo.getAssessmentsForTrainee(traineeId);
    }
}
