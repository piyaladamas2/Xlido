package com.crio.xlido.Repository;

import java.util.List;
import java.util.Optional;
import com.crio.xlido.Entities.Question;



public interface IQuestionRepository {
    Question save(Question question);
    List<Question> findAll();
    Optional<Question> findById(Long id);
    Question removeQuestion(Long id);
    List<Question> findByEventId(Long eventId);
    
}


