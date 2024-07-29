package com.crio.xlido.Entities;

public class Answers {

    
    private String contentString;
    private Long userId;
    private Long questionId;
    
    public Answers(String name, Long userId, Long questionId) {
        this.contentString = name;
        this.userId = userId;
        this.questionId = questionId;
    }
   
   
    public String getContentString() {
        return contentString;
    }
    public void setContenString(String contenString) {
        this.contentString = contenString;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    @Override
    public String toString() {
        return "Answers [contentString=" + contentString + ", questionId=" + questionId
                + ", userId=" + userId + "]";
    }

    
}
