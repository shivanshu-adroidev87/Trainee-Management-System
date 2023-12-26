package com.nucleus.project.controller;


import com.nucleus.project.bean.Assessment;
import com.nucleus.project.bean.Batch;
import com.nucleus.project.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TraineeController {
    @Autowired
    private TraineeService service;
    @GetMapping(value = "/traineeLogin")
    public ModelAndView showMakerDashboard(){
        ModelAndView model = new ModelAndView();
        model.setViewName("traineeDashboard");
        return model;
    }

    @GetMapping(value = "/fetchDetailsForTrainee")
    public ModelAndView fetchDetailsForTrainee(@RequestParam("action") String action, Authentication authentication){
        ModelAndView modelAndView = new ModelAndView("traineeDashboard");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        int traineeId = Character.getNumericValue(userDetails.getUsername().charAt(userDetails.getUsername().length()-1));
        if(action.equals("showBatchDetails")){
            Batch batch = service.getBatchDetails(traineeId);
            modelAndView.addObject("batch",batch);
        }else if(action.equals("showAssessments")){
            List<Assessment> assessmentList = service.getAssessmentsForTrainee(traineeId);
            modelAndView.addObject("assessmentList",assessmentList);
        }
        return modelAndView;
    }
}
