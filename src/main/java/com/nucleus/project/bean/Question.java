package com.nucleus.project.bean;
import javax.persistence.*;


@Entity
@Table(name = "question_17129")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    private String questionName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    public Question(int questionId, String questionName, Assessment assessment) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.assessment = assessment;
    }


    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQuestion() {
        return questionName;
    }
    public void setQuestion(String question) {
        this.questionName = question;
    }
    public Assessment getAssessment() {
        return assessment;
    }
    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

}
