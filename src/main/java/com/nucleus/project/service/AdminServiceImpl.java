package com.nucleus.project.service;

import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;
import com.nucleus.project.bean.Trainee;
import com.nucleus.project.bean.TraineeDTO;
import com.nucleus.project.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepo adminRepo;
    @Override
    public boolean registerTrainee(TraineeDTO trainee) {
        return adminRepo.registerTrainee(trainee);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return adminRepo.getAllTrainees();
    }

    @Override
    public boolean registerBatch(Batch batch, Authentication authentication) {
        return adminRepo.registerBatch(batch,authentication);
    }

    @Override
    public List<Batch> getAllBatch() {
        return adminRepo.getAllBatches();
    }

    @Override
    public Batch getBatchById(int batchId) {
        return adminRepo.getBatchById(batchId);
    }

    @Override
    public boolean addNewAssessment(Assessment assessment) {
        return adminRepo.addNewAssessment(assessment);
    }

    @Override
    public List<Assessment> getAllAssessments() {
        return adminRepo.getAllAssessments();
    }

    @Override
    public Trainee getTrainerById(int traineeId) {
        return adminRepo.getTraineeById(traineeId);
    }

    @Override
    public boolean editTrainee(Trainee trainee) {
        return adminRepo.updateTrainee(trainee);
    }

    @Override
    public boolean deleteTrainee(int traineeId) {
        return adminRepo.deleteTrainee(traineeId);
    }

    @Override
    public boolean addQuestionToAssessment(Assessment assessment) {
        return adminRepo.addQuestionToAssessment(assessment);
    }

    @Override
    public Assessment getAssessmentById(int assessmentId) {
        return adminRepo.getAssessmentById(assessmentId);
    }

    @Override
    public List<Assessment> getAssessmentByBatch(Batch batch) {
        return adminRepo.getAssessmentByBatch(batch);
    }

    @Override
    public List<Trainee> unassignedTrainee() {
        return adminRepo.unassignedTrainee();
    }

    @Override
    public boolean assignExistingTrainee(int traineeId, int batchId) {
        return  adminRepo.assignExistingTrainee(traineeId,batchId);
    }

    @Override
    public boolean deleteBatch(int batchId) {
        return adminRepo.deleteBatch(batchId);
    }
}
