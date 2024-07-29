package com.crio.xlido.Repository;
import java.util.Optional;
import com.crio.xlido.Entities.User;

public interface IUserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    
}
