package com.nucleus.project.controller;


import com.nucleus.project.bean.*;
import com.nucleus.project.service.AdminService;
import com.nucleus.project.traineeValidator.TraineeDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAdminController {

    @Autowired
    private AdminService service;
    @Autowired
    private TraineeDTOValidator traineeDTOValidator;
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDate.class,new CustomProperty());
    }

    @PostMapping(value = "/traineeDetailsSubmit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView addTrainee(@RequestBody @Validated TraineeDTO traineeDTO, BindingResult result) {
        try {
                traineeDTOValidator.validate(traineeDTO,result);
                if(result.hasErrors()) {

                    return new ModelAndView("registerTrainee")
                            .addObject("traineeDTO", traineeDTO)  // Add the original data for repopulating the form
                            .addObject("errors", result.getAllErrors());
                }
                else {
                    service.registerTrainee(traineeDTO);
                    return new ModelAndView("traineeSuccess");
                }

        } catch (Exception e) {

            return new ModelAndView("errorPage");
        }
    }
    @PostMapping(value = "/questionSubmit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> submitQuestion(@RequestBody QuestionDTO questionDTO) {
        try {
            List<String> questionName = questionDTO.getQuestionList();
            System.out.println("hello welcome");
            List<Question> questionList = new ArrayList<>();
            for(String question :questionName){
                Question question1 = new Question();
                question1.setQuestion(question);
                questionList.add(question1);

            }
            Assessment assessment = new Assessment(questionDTO.getAssessmentName(),questionList);

            service.addQuestionToAssessment(assessment);
            return ResponseEntity.ok("question saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to save question data: " + e.getMessage());
        }
    }

}
