package com.nucleus.project.aop;

import com.nucleus.project.bean.Batch;
import com.nucleus.project.bean.Trainee;
import com.nucleus.project.bean.TraineeDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Aspect
public class AopImpl {
    public static final Logger logger = LoggerFactory.getLogger(AopImpl.class.getName());

    //Around advice method for insert trainee

    @Around("execution(* com.nucleus.project.service.AdminServiceImpl.registerTrainee(..)) && args(trainee)")
    public Object aroundAdviceRegister(ProceedingJoinPoint joinPoint, TraineeDTO trainee) throws Throwable {
        String value = "Trainee record with Name :"+trainee.getTraineeName()+" ready to insert into the table ";
        logger.info(value);
        Object result = joinPoint.proceed();
        value="Trainee Name : "+trainee.getTraineeName()+" inserted successfully..";
        logger.info(value);
        return result;
    }

    //before advice method , getting all master customers

    @AfterReturning(value = "execution(* com.nucleus.project.service.AdminServiceImpl.getAllTrainees())" , returning = "traineeList")
    public void beforeGettingMasterCustomers(JoinPoint joinPoint, List<Trainee> traineeList) {
        String value="Retrieving all trainee records  : "+joinPoint.getSignature().getName()+"\n Returned Trainee List : \n"+traineeList;
        logger.info(value);
    }

//    //after returning advice method , getting all temporary customer's record

    @AfterReturning(value = "execution(* com.nucleus.project.service.AdminServiceImpl.getAllBatch())" , returning = "batchList")
    public void afterGettingTempCustomers(JoinPoint joinPoint, List<Batch> batchList) {
        String value = "Retrieving all batches  :  "+joinPoint.getSignature().getName()+"\n Returned Customer List : \n"+batchList;
        logger.info(value);
    }

}
