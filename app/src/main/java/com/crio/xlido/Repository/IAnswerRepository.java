package com.crio.xlido.Repository;

import java.util.List;
import java.util.Optional;
import com.crio.xlido.Entities.Answers;

public interface IAnswerRepository {
    Answers save(Answers answers);
    List<Answers> findAll();
    Optional<Answers> findById(Long id);
    Answers removeAnswers(Long id);
    
    
}
