package com.crio.xlido.Entities;

public class Event extends BaseEntity {
    public Event(Long id) {
        super(id);
        //TODO Auto-generated constructor stub
    }
    private String name;
    private Long userId;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Event(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public Event(Long eventId,Event event) {
         super(eventId);
         this.name = event.getName();
         this.userId = event.getUserId();
     }

}
