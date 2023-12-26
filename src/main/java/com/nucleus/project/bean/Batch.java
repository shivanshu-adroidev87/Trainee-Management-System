package com.nucleus.project.bean;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "batch_17129")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private int batchId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxTrainee;
    private String supervisedBy;
    private LocalDate creationDate;
    private String creator;
    private String batchType;
    private String batchStatus;
    private String batchDescription;
    @OneToMany(cascade = CascadeType.REMOVE, fetch =FetchType.EAGER)
    @JoinColumn(name="batch_id")
    private List<Trainee> traineeList;

    @ManyToMany(mappedBy = "batchList",cascade = CascadeType.REMOVE)
    private List<Assessment> assessmentList;

    public Batch(LocalDate startDate, LocalDate endDate, int maxTrainee, String supervisedBy,String batchType,String batchStatus,String batchDescription) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxTrainee = maxTrainee;
        this.supervisedBy = supervisedBy;
        this.batchDescription=batchDescription;
        this.batchType = batchType;
        this.batchStatus=batchStatus;
    }

    public Batch() {
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setMaxTrainee(int maxTrainee) {
        this.maxTrainee = maxTrainee;
    }

    public void setSupervisedBy(String supervisedBy) {
        this.supervisedBy = supervisedBy;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getCreator() {
        return creator;
    }

    public String getBatchType() {
        return batchType;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public String getBatchDescription() {
        return batchDescription;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getMaxTrainee() {
        return maxTrainee;
    }


    public String getSupervisedBy() {
        return supervisedBy;
    }


    public List<Trainee> getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List<Trainee> traineeList) {
        this.traineeList = traineeList;
    }


    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", maxTrainee=" + maxTrainee +
                ", supervisedBy='" + supervisedBy + '\'' +
                ", creationDate=" + creationDate +
                ", creator='" + creator + '\'' +
                ", batchType='" + batchType + '\'' +
                ", batchStatus='" + batchStatus + '\'' +
                ", batchDescription='" + batchDescription + '\'' +
                '}';
    }
}
