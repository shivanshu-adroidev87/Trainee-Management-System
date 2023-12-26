package com.nucleus.project.traineeValidator;

import com.nucleus.project.bean.Trainee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class TraineeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Trainee.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Trainee trainee = (Trainee) target;

        if(!isNameValid(trainee.getTraineeName())){
            errors.rejectValue("traineeName", "traineeName.invalid",
                    "trainee Name can only have a-z, A-Z, ");
        }

        if(!isNameValid(trainee.getNationality())){
            errors.rejectValue("nationality", "nationality.invalid",
                    "trainee nationality can only have a-z, A-Z, ");
        }

        //validating email format
        if(!isEmailValid(trainee.getEmailId())){
            errors.rejectValue("emailId", "email.invalid",
                    "Email Address not in valid format");
        }


        //validating contact number
        if(!isValidContact(String.valueOf(trainee.getContact()))){
            errors.rejectValue("contact", "contactNumber.invalid",
                    "Contact number should be at least 10 digits");
        }
    }
    public boolean isNameValid(String name){
        String regex = "^[a-zA-Z ]+$";
        return name.matches(regex);
    }
    public boolean isValidContact(String contact){
        return contact.length()>=10;
    }

    public boolean isEmailValid(String email){
        String emailRegex = "[a-zA-Z0-9_/-/.]+[@][a-zA-Z]+[/.][a-zA-Z]{2,3}";
        Matcher matcher = Pattern.compile(emailRegex).matcher(email);
        return matcher.matches();
    }

}
