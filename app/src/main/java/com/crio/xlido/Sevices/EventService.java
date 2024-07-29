package com.crio.xlido.Sevices;


import java.util.Optional;
import com.crio.xlido.Entities.Event;
import com.crio.xlido.Entities.User;
import com.crio.xlido.Repository.IEventRepository;
import com.crio.xlido.Repository.IUserRepository;


public class EventService {
   
    private IEventRepository iEventRepository;
    private IUserRepository iUserRepository;

    
    

    public EventService(IEventRepository iEventRepository,IUserRepository iUserRepository) {
        this.iEventRepository = iEventRepository;
        this.iUserRepository = iUserRepository;
    }




    public Event creatEvent(String eventName,Long userId){
        iUserRepository.findById(userId).orElseThrow(()-> new RuntimeException("User with an id "+userId+" does not exist"));
       return iEventRepository.save(new Event(eventName, userId));
    }
    

    public Event deleteEvent(Long eventId, Long userId){
     Event event =  iEventRepository.findById(eventId).orElseThrow(()-> new RuntimeException("Event with an id "+eventId+" does not exist"));
        iUserRepository.findById(userId).orElseThrow(()-> new RuntimeException("User with an id "+userId+" does not exist"));

        if(event.getUserId()!= userId) throw new RuntimeException("User with an id "+userId+" is not a organizer of Event with an id "+eventId);

        return iEventRepository.removeEvent(eventId);
    }
}
