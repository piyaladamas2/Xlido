package com.crio.xlido.Repository;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.crio.xlido.Entities.User;

public class UserRepository implements IUserRepository {

    private final Map<Long, User> storage = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(0);


    @Override
    public User save(User userInput) {
        User user= new User(idCounter.incrementAndGet(),userInput);
        storage.putIfAbsent(user.getId(),user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
       
        return Optional.ofNullable(storage.get(id));
    }

   
    
}
