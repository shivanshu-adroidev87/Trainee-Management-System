package com.nucleus.project.controller;

import com.nucleus.project.bean.*;
import com.nucleus.project.traineeValidator.BatchValidator;
import com.nucleus.project.traineeValidator.TraineeValidator;
import com.nucleus.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService service;
    @Autowired
    private TraineeValidator traineeValidator;
    @Autowired
    private BatchValidator batchValidator;
    static final String adminRedirect = "redirect:/adminLogin";
    static final String traineeRedirect = "redirect:/traineeLogin";
    static final String traineeVal = "trainee";
    static final String batchListVal = "batchList";
    static final String errorPageVal = "errorPage";
    static  final String batchDetailsVal = "batchDetails";



    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDate.class,new CustomProperty());
    }

    //redirecting to maker/checker dashboard page from the login page
    @RequestMapping("/login")
    public String goToMakerChecker(Authentication authentication) {
        UserDetails  userDetails=null;
        String role=null;
        if(authentication!=null) {
            userDetails = (UserDetails) authentication.getPrincipal();
             role = userDetails.getAuthorities().toString();
            if (role.equals("[ROLE_ADMIN]")) {
                return adminRedirect;
            } else {
                return traineeRedirect;
            }
        }
        else
            return errorPageVal;
    }




    //showing maker dashboard page while maker logging in
   @GetMapping(value = "/adminLogin")
    public ModelAndView showMakerDashboard(){
        ModelAndView model = new ModelAndView();
        List<Trainee> traineeList = service.getAllTrainees();
        model.addObject("traineeList",traineeList);
        model.setViewName("adminDashboard");
        return model;
    }


    @GetMapping(value = "/registerTrainee")
    public ModelAndView registerTrainee(){
        ModelAndView model = new ModelAndView();
        model.addObject(new Trainee());
        List<Batch> batchList = service.getAllBatch();
        model.addObject(batchListVal, batchList);
        model.setViewName("registerTrainee");
        return model;
    }


    @GetMapping(value = "/registerBatch")
    public ModelAndView registerBatch(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerBatch");
        modelAndView.addObject(new Batch());
        return modelAndView;
    }


    @GetMapping(value = "/submitBatch")
    public ModelAndView submitTrainee(@ModelAttribute("batch")Batch batch,BindingResult result,Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        batchValidator.validate(batch,result);
        if(!result.hasErrors()) {
            if (service.registerBatch(batch, authentication)) {
                List<Batch> batches = service.getAllBatch();
                modelAndView.addObject(batchListVal, batches);
                modelAndView.setViewName(batchDetailsVal);
            }else{
                modelAndView.setViewName(errorPageVal);
            }
        }
        else{
            return new ModelAndView("registerBatch");
        }
        return modelAndView;
    }


    @GetMapping(value = "/createAssessment")
    public ModelAndView goToAssessmentForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createAssessment");
        modelAndView.addObject(new Assessment());
        return modelAndView;
    }

    @GetMapping(value = "/assessmentCreation")
    public String createAssessment(@ModelAttribute("assessmentCreation") Assessment assessment) {
        service.addNewAssessment(assessment);
        return adminRedirect;
    }


    @GetMapping(value = "/editTrainee/{traineeId}")
    public String editTraineeForm(@PathVariable("traineeId") int traineeId,Model model) {
        Trainee trainee = service.getTrainerById(traineeId);
        model.addAttribute(trainee);
        return "editTraineeForm";
    }

    @GetMapping(value = "/editTrainee/editTraineeSubmit")
    public String editTraineeSubmit(@ModelAttribute("trainee") Trainee trainee, BindingResult result, Model model) {
        traineeValidator.validate(trainee,result);
        if(!result.hasErrors()){
            service.editTrainee(trainee);
            model.addAttribute(traineeVal,trainee);
            return "updateTraineeSuccess";
        }
        else {
            return "editTraineeForm";
        }
    }


    @GetMapping(value = "/deleteTrainee/{traineeId}")
    public String deleteTrainee(@PathVariable("traineeId") int traineeId,Model model) {
        service.deleteTrainee(traineeId);
        return adminRedirect;
    }

    @GetMapping(value = "/traineeSuccess")
    public String traineeSuccess(){
        return "traineeSuccess";
    }

    @GetMapping(value = "/errorPage")
    public String traineeSubmissionError(){
        return errorPageVal;
    }


    @GetMapping(value = "/retrieveAssessments")
    public String getAllAssessments(Model model) {
        List<Assessment> assessmentList = service.getAllAssessments();
        model.addAttribute("assessmentList",assessmentList);
        return "assessmentDetails";
    }
    @GetMapping(value = "/batchDetails/{assessmentId}")
    public ModelAndView showBatches(@PathVariable("assessmentId") int assessmentId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("batchDetailsForAssessment");
        List<Batch> batches = service.getAllBatch();
        for(int i=0;i< batches.size();i++){
            List<Assessment> assessmentList = service.getAssessmentByBatch(batches.get(i));
            if(assessmentList.isEmpty())
                continue;
            for(Assessment assessment : assessmentList){
                if(assessment.getAssessmentId()==assessmentId) {
                    batches.remove(i);
                    i--;
                    break;
                }
            }
        }
        modelAndView.addObject(batchListVal,batches);
        modelAndView.addObject("assessmentId",assessmentId);
        return modelAndView;
    }

    @GetMapping(value = "/assignAssessmentToBatch/{assessmentId}")
    public String handleBatchFormSubmission(@PathVariable("assessmentId") int assessmentId,@RequestParam(value = "batchIds", required = false) String[] batchIds) {
        Assessment assessment = service.getAssessmentById(assessmentId);
        List<Batch> batchList = new ArrayList<>();
        if (batchIds != null) {
            for (String batchId : batchIds) {
                Batch batch = service.getBatchById(Integer.parseInt(batchId));
                batchList.add(batch);
            }
        }
        assessment.setBatchList(batchList);
        service.addNewAssessment(assessment);
        return adminRedirect;
    }

    @GetMapping(value = "/retrieveTraineeDetails")
    public ModelAndView retrieveTraineeDetails(){
        ModelAndView modelAndView = new ModelAndView("unassignedTrainee");
        List<Trainee> traineeList = service.unassignedTrainee();
        modelAndView.addObject("traineeList",traineeList);
        return modelAndView;
    }

    @GetMapping(value = "/fetchBatchForTrainee/{traineeId}")
    public ModelAndView fetchBatchForTrainee(@PathVariable("traineeId") int traineeId){
        List<Batch> batches = service.getAllBatch();
        ModelAndView modelAndView = new ModelAndView("fetchBatchForTrainee");
        modelAndView.addObject(batchListVal,batches);
        modelAndView.addObject("traineeId",traineeId);
        return modelAndView;
    }
    @GetMapping(value = "/fetchBatchForTrainee/assignBatchToPreviousTrainee/{traineeId}")
    public String assignBatchToPreviousTrainee(@PathVariable("traineeId") int traineeId,@RequestParam("selectedBatch") int batchId){
        if(service.assignExistingTrainee(traineeId,batchId)){
            return adminRedirect;
        }else {
            return errorPageVal;
        }
    }

    @GetMapping(value = "/deleteBatch/{batchId}")
    public String deleteBatch(@PathVariable("batchId") int batchId){
        if(service.deleteBatch(batchId)){
            return batchDetailsVal;
        }else{
            return errorPageVal;
        }
    }

    @GetMapping(value = "/batchDetails")
    public ModelAndView batchDetails(){
        ModelAndView modelAndView = new ModelAndView();
        List<Batch> batches = service.getAllBatch();
        modelAndView.addObject(batchListVal, batches);
        modelAndView.setViewName(batchDetailsVal);
        return modelAndView;
    }

}
