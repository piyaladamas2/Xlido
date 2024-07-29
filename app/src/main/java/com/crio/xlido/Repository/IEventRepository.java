package com.crio.xlido.Repository;

import java.util.List;
import java.util.Optional;
import com.crio.xlido.Entities.Event;


public interface IEventRepository {
    Event save(Event event);
        List<Event> findAll();
        Optional<Event> findById(Long id);
        Event removeEvent(Long id);

}
