package com.nucleus.project.service;

import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;
import com.nucleus.project.bean.Trainee;
import com.nucleus.project.bean.TraineeDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AdminService {
    boolean registerTrainee(TraineeDTO trainee);
    List<Trainee> getAllTrainees();
    boolean registerBatch(Batch batch, Authentication authentication);
    List<Batch> getAllBatch();
    Batch getBatchById(int batchId);
    boolean addNewAssessment(Assessment assessment);
    List<Assessment> getAllAssessments();
    Trainee getTrainerById(int traineeId);
    boolean editTrainee(Trainee trainee);
    boolean deleteTrainee(int traineeId);
    boolean addQuestionToAssessment(Assessment assessment);
    Assessment getAssessmentById(int assessmentId);
    List<Assessment> getAssessmentByBatch(Batch batch);
    List<Trainee> unassignedTrainee();
    boolean assignExistingTrainee(int traineeId,int batchId);
    boolean deleteBatch(int batchId);
}
