package com.nucleus.project.bean;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trainee_17129")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainee_id")
    private int traineeId;
    private String traineeName;
    private LocalDate registrationDate;
    private LocalDate enrollDate;
    private String emailId;
    private long contact;
    private String address;
    private String gender;
    private String nationality;
    private String highestQualification;
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Trainee(String traineeName,String emailId, long contact, String address,String gender,String nationality,String highestQualification) {
        this.traineeName = traineeName;
        this.emailId = emailId;
        this.contact = contact;
        this.address = address;
        this.nationality=nationality;
        this.highestQualification=highestQualification;
        this.gender=gender;
    }

    public Trainee() {
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getEmailId() {
        return emailId;
    }

    public long getContact() {
        return contact;
    }
    public String getAddress() {
        return address;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

}
