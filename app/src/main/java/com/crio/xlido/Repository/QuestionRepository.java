package com.crio.xlido.Repository;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import com.crio.xlido.Entities.Question;


public class QuestionRepository implements IQuestionRepository {

   
    
    private final Map<Long, Question> QuestionMap = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(0);

    @Override
    public Question save(Question entity) {

        if(entity.getId()!= null){
            QuestionMap.put(entity.getId(), entity);
            return entity;
        }
            Question question = new Question(idCounter.incrementAndGet(),entity);
            QuestionMap.putIfAbsent(question.getId(),question);
            return question;
    }


    @Override
    public List<Question> findAll() {
        return new ArrayList<>(QuestionMap.values());
    }

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.ofNullable(QuestionMap.get(id));
    }


    @Override
    public Question removeQuestion(Long id) {
        // TODO Auto-generated method stub
        return QuestionMap.remove(id);
    }
    @Override
    public List<Question> findByEventId(Long eventId){
        return QuestionMap.values().stream().filter(i-> i.getEventId() == eventId).collect(Collectors.toList());
    }
    

    // Redundant method removed: listOfQuestions(Long eventID, String order) 
}
