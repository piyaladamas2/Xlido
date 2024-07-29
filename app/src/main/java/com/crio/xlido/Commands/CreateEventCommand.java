package com.crio.xlido.Commands;

import java.util.List;

import com.crio.xlido.Entities.Event;
import com.crio.xlido.Sevices.EventService;



public class CreateEventCommand implements ICommand {

    private final EventService eventServices;

    public CreateEventCommand(EventService eventServices){
        this.eventServices= eventServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.size()==2){
        String name= tokens.get(1);
        Long organizerID= Long.valueOf(tokens.get(2));
        
        Event event = eventServices.creatEvent(name, organizerID);
        System.out.println("Event ID :"+event.getId());
        }else{

            throw new RuntimeException("error token");
        }
       
        
    }
    
}
