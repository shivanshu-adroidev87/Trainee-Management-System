package com.nucleus.project.bean;

import java.util.List;

public class QuestionDTO {
    private String assessmentName;

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    private List<String> questionList;

    public List<String> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }

    public QuestionDTO(String assessmentName, List<String> questionList) {
        this.assessmentName = assessmentName;
        this.questionList = questionList;
    }

    public QuestionDTO() {
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "questionList=" + questionList +
                '}';
    }
}
