package com.nucleus.project.repo;

import com.nucleus.project.aop.AopImpl;
import com.nucleus.project.bean.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class AdminRepoImpl implements AdminRepo{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean registerTrainee(TraineeDTO trainee) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Trainee trainee1 = new Trainee(trainee.getTraineeName(),trainee.getEmailId(),trainee.getContact(),trainee.getAddress(),trainee.getGender(),trainee.getNationality(),trainee.getHighestQualification());
            if(trainee.getTableBatchId()!=0)
            {
                trainee1.setEnrollDate(LocalDate.now());
                trainee1.setBatch(getBatchById(trainee.getTableBatchId()));
            }
            trainee1.setRegistrationDate(LocalDate.now());
            session.save(trainee1);
            return true;
        }catch (Exception e){
            String value="Exception occured at time of registering a trainee  \n"+trainee;
            AopImpl.logger.info(value);
            return false;
        }
    }

    @Override
    public List<Trainee> getAllTrainees() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from Trainee", Trainee.class).list();
        }catch (Exception e){
            AopImpl.logger.info("Exception while fetching trainee records");
            return Collections.emptyList();
        }
    }

    @Override
    public boolean registerBatch(Batch batch, Authentication authentication) {
        try{
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Session session = sessionFactory.getCurrentSession();
            batch.setCreationDate(LocalDate.now());
            batch.setCreator(userDetails.getUsername());
            session.saveOrUpdate(batch);
            return true;
        }catch (Exception exception){
            AopImpl.logger.info("Exception occured while registering batch ");
            return false;
        }
    }

    @Override
    public List<Batch> getAllBatches() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from Batch", Batch.class).list();
        }catch (Exception exception){
            AopImpl.logger.info("Exception occured while getting all batches");
            return Collections.emptyList();
        }
    }

    @Override
    public Batch getBatchById(int batchId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.get(Batch.class,batchId);
        }catch (Exception e){
            AopImpl.logger.info("Exception while fetching Batch details");
            return null;
        }
    }

    @Override
    public boolean addNewAssessment(Assessment assessment) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Assessment assessment1 = session.get(Assessment.class,assessment.getAssessmentId());
            if(assessment1!=null){
                List<Batch> batchList= assessment1.getBatchList();
                for(Batch batch : assessment.getBatchList()){
                    batchList.add(batch);
                }
                assessment.setBatchList(batchList);
            }
            session.saveOrUpdate(assessment);
            return true;
        }catch (Exception exception){
            AopImpl.logger.info("Exception while entering a new Assessment ");
            return false;
        }
    }

    @Override
    public List<Assessment> getAllAssessments() {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from Assessment", Assessment.class).list();
        }catch (Exception exception){
            AopImpl.logger.info("Exception in getting all Assessments");
            return Collections.emptyList();
        }
    }

    @Override
    public Trainee getTraineeById(int traineeId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.get(Trainee.class,traineeId);
        }
        catch (Exception exception){
            AopImpl.logger.info("Exception while retrieving trainee record");
            return null;
        }
    }

    @Override
    public boolean updateTrainee(Trainee trainee) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Trainee trainee1 = session.get(Trainee.class,trainee.getTraineeId());
            trainee1.setTraineeName(trainee.getTraineeName());
            trainee1.setAddress(trainee.getAddress());
            trainee1.setContact(trainee.getContact());
            trainee1.setAddress(trainee.getAddress());
            trainee1.setNationality(trainee.getNationality());
            trainee1.setHighestQualification(trainee.getHighestQualification());
            trainee1.setEmailId(trainee.getEmailId());
            trainee1.setGender(trainee.getGender());
            session.update(trainee1);
            return true;
        }catch (Exception exception){
            String value = "Exception in updating trainee "+trainee;
            AopImpl.logger.info(value);
            return false;
        }
    }

    @Override
    public boolean deleteTrainee(int traineeId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Trainee trainee = session.get(Trainee.class,traineeId);
            session.delete(trainee);
            return true;
        }catch (Exception exception){
            String value = "Exception while deleting trainee Id  "+traineeId;
            AopImpl.logger.info(value);
            return false;
        }
    }

    @Override
    public boolean addQuestionToAssessment(Assessment assessment) {
        try {

            Session session = sessionFactory.getCurrentSession();
            session.save(assessment);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public Assessment getAssessmentById(int assessmentId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return session.get(Assessment.class,assessmentId);
        }catch (Exception e){
            String value ="Exception while retrieving assessment id : "+assessmentId;
            AopImpl.logger.info(value);
            return null;
        }
    }

    @Override
    public List<Assessment> getAssessmentByBatch(Batch batch) {
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql = "select b.assessmentList from Batch b where b.batchId = :batchId";
            Query query = session.createQuery(hql);
            query.setParameter("batchId",batch.getBatchId());
            return query.getResultList();
        }catch (Exception exception){
            String value = "Exception while retrieving assessment of "+batch.getBatchId();
            AopImpl.logger.info(value);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Trainee> unassignedTrainee() {
        try{
            Session session = sessionFactory.getCurrentSession();
            List<Trainee> trainees = new ArrayList<>();
            List<Trainee> traineeList = session.createQuery("from Trainee", Trainee.class).list();
            for(Trainee trainee : traineeList){

                if(trainee.getBatch()==null){
                    trainees.add(trainee);
                }
            }
            return trainees;
        }catch (Exception exception){
            String value = "Exception in getting trainee details";
            AopImpl.logger.info(value);
            return Collections.emptyList();
        }
    }

    @Override
    public boolean assignExistingTrainee(int traineeId, int batchId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Trainee trainee = session.get(Trainee.class,traineeId);
            trainee.setEnrollDate(LocalDate.now());
            Batch batch = session.get(Batch.class,batchId);
            trainee.setBatch(batch);
            session.saveOrUpdate(trainee);
            return true;
        }catch (Exception e){
            String value = "Exception :  "+e.getMessage()+" assigning "+traineeId+"  to "+batchId;
            AopImpl.logger.info(value);
            return false;
        }
    }

    @Override
    public boolean deleteBatch(int batchId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Batch batch = session.get(Batch.class,batchId);
            session.delete(batch);
            return true;
        }catch (Exception exception){
            String value = "Exception in deletion of "+batchId;
            AopImpl.logger.info(value);
            return false;
        }
    }
}
