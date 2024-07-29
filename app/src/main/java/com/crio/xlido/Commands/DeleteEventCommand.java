package com.crio.xlido.Commands;

import java.util.List;
import com.crio.xlido.Sevices.EventService;


public class DeleteEventCommand implements ICommand {

    private final EventService eventServices;

    public DeleteEventCommand(EventService eventServices){
        this.eventServices= eventServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub

        Long eventID= Long.valueOf(tokens.get(1));
        Long organizerID= Long.valueOf(tokens.get(2));

        
            eventServices.deleteEvent(eventID, organizerID);
          
       
       
    }
}


