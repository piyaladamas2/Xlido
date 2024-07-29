package com.crio.xlido.Entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question extends BaseEntity {
    private String content;
    private Long userId;
    private Long eventId;
    private List<Long> voted_userId;
    private Integer upvote;
    public Question(String content, Long userId, Long eventId) {
        this.content = content;
        this.userId = userId;
        this.eventId = eventId;
        this.voted_userId = new ArrayList<>();
        this.upvote = 0;
    }
    public Question(Long quesId, Question question) {
        super(quesId);
        this.content = question.getContent();
        this.userId = question.getUserId();
        this.eventId = question.getEventId();
        this.voted_userId = question.getVoted_userId();
        this.upvote = question.getUpvote();
    }
    public List<Long> getVoted_userId() {
        return voted_userId;
    }
    public void setVoted_userId(List<Long> voted_userId) {
        this.voted_userId = voted_userId;
    }
    public Integer getUpvote() {
        return upvote;
    }
    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    @Override
    public String toString() {
        return "Question [content=" + content + ", eventId=" + eventId + ", upvote=" + upvote
                + ", userId=" + userId + ", voted_userId=" + voted_userId + "]";
    }

}
