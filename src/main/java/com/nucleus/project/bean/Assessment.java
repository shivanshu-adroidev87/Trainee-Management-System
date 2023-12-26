package com.nucleus.project.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assessment_17129")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private int assessmentId;
    private String assessmentName;
    @ManyToMany
    @JoinTable(
            name = "batch_assessment_17129",
            joinColumns = @JoinColumn(name = "assessment_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private List<Batch> batchList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "assessment_id")
    private List<Question> questionList;

    public Assessment() {
    }

    public Assessment(String assessmentName,List<Question> questionList) {
        this.assessmentName = assessmentName;
        this.questionList = questionList;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }


    @Override
    public String toString() {
        return "Assessment{" +
                "assessmentId=" + assessmentId +
                ", assessmentName='" + assessmentName + '\'' +
                '}';
    }
}

