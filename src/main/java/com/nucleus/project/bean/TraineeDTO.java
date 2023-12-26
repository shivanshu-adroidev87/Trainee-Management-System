package com.nucleus.project.bean;

public class TraineeDTO {
    private String traineeName;
    private String emailId;
    private long contact;
    private String address;
    private String gender;
    private String nationality;
    private String highestQualification;
    private int tableBatchId;

    // Constructors, getters, and setters

    public TraineeDTO() {
    }

    public TraineeDTO(String traineeName, String emailId, long contact, String address,
                      String gender, String nationality, String highestQualification, int tableBatchId) {
        this.traineeName = traineeName;
        this.emailId = emailId;
        this.contact = contact;
        this.address = address;
        this.gender = gender;
        this.nationality = nationality;
        this.highestQualification = highestQualification;
        this.tableBatchId = tableBatchId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHighestQualification() {
        return highestQualification;
    }
    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }
    public int getTableBatchId() {
        return tableBatchId;
    }

    public void setTableBatchId(int tableBatchId) {
        this.tableBatchId = tableBatchId;
    }

    @Override
    public String toString() {
        return "TraineeDTO{" +
                "traineeName='" + traineeName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contact=" + contact +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", highestQualification='" + highestQualification + '\'' +
                ", tableBatchId=" + tableBatchId +
                '}';
    }
}
