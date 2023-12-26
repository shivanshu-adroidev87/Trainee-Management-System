package com.nucleus.project.traineeValidator;

import com.nucleus.project.bean.Batch;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class BatchValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Batch.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Batch batch = (Batch) target;
        if(batch.getStartDate().compareTo(batch.getEndDate())>0){
            errors.rejectValue("startDate", "startDate.invalid",
                    "Start date should be less than end date");
        }
        if(batch.getMaxTrainee()>40){
            errors.rejectValue("maxTrainee", "maxTrainee.invalid",
                    "Max trainee should be less than or equal to 40");
        }
        if(getNumberOfDays(batch.getStartDate(),batch.getEndDate())<90 || getNumberOfDays(batch.getStartDate(),batch.getEndDate())>130){
            errors.rejectValue("endDate", "endDate.invalid",
                    "total days should be at least 90 and less than 130");
        }

    }
    public long getNumberOfDays(LocalDate startDate,LocalDate endDate){
        return startDate.until(endDate, ChronoUnit.DAYS);
    }
}
