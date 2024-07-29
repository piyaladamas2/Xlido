package com.crio.xlido.Sevices;

import com.crio.xlido.Entities.User;
import com.crio.xlido.Repository.IUserRepository;

public class UserService {

    
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name,String email){
      return  userRepository.save(new User(name, email));
    }


    
}
