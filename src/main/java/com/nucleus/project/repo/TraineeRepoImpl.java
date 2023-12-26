package com.nucleus.project.repo;

import com.nucleus.project.aop.AopImpl;
import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class TraineeRepoImpl implements TraineeRepo{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Batch getBatchDetails(int traineeId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql = "SELECT t.batch FROM Trainee t WHERE t.traineeId = :traineeId";
            Query query = session.createQuery(hql, Batch.class);
            query.setParameter("traineeId",traineeId);
            return (Batch) query.uniqueResult();
        }catch (Exception e){
            String value="Exception while retrieving batch details for "+traineeId;
            AopImpl.logger.info(value);
            return null;
        }
    }

    @Override
    public List<Assessment> getAssessmentsForTrainee(int traineeId) {
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql = "SELECT t.batch FROM Trainee t WHERE t.traineeId = :traineeId";
            Query query = session.createQuery(hql, Batch.class);
            query.setParameter("traineeId",traineeId);
            Batch batch = (Batch) query.uniqueResult();
            System.out.println("Batch "+batch+"\n");


            String hql1 = "select distinct a from Batch b " +
                    "join b.assessmentList a " +
                    "where b.batchId = :batchId";
            Query query1 = session.createQuery(hql1, Assessment.class);
            query1.setParameter("batchId", batch.getBatchId());
            List<Assessment> assessmentList = query1.list();

            System.out.println("First element "+assessmentList);
            return assessmentList;

        }catch (Exception e){
            String value="Exception while retrieving batch details for "+traineeId;
            AopImpl.logger.info(value);
           e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
