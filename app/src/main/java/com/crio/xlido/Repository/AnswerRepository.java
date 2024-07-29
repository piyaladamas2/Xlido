package com.crio.xlido.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.xlido.Entities.Answers;

public class AnswerRepository implements IAnswerRepository {

    private final Map<Long, Answers> AnswersMap = new HashMap<>();
    // private AtomicLong idCounter = new AtomicLong(0);
 
     @Override
     public Answers save(Answers entity) {
           AnswersMap.putIfAbsent(entity.getQuestionId(),entity);
             return entity;
     }
 
 
     @Override
     public List<Answers> findAll() {
         return new ArrayList<>(AnswersMap.values());
     }
 
     @Override
     public Optional<Answers> findById(Long id) {
         return Optional.ofNullable(AnswersMap.get(id));
     }
 
 
     @Override
     public Answers removeAnswers(Long id) {
         // TODO Auto-generated method stub
         return AnswersMap.remove(id);
     }
 
    
}
