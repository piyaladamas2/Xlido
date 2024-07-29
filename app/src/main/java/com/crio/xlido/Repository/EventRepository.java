package com.crio.xlido.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.crio.xlido.Entities.Event;


public class EventRepository implements IEventRepository{

    private final Map<Long, Event> EventMap = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(0);

    @Override
    public Event save(Event entity) {
            Event Event = new Event(idCounter.incrementAndGet(),entity);
            EventMap.putIfAbsent(Event.getId(),Event);
            return Event;
    }


    @Override
    public List<Event> findAll() {
        return new ArrayList<>(EventMap.values());
    }

    @Override
    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(EventMap.get(id));
    }


    @Override
    public Event removeEvent(Long id) {
        // TODO Auto-generated method stub
        return EventMap.remove(id);
    }
}


   
    

