package com.crio.xlido.Sevices;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.crio.xlido.Entities.Answers;
import com.crio.xlido.Entities.Question;
import com.crio.xlido.Repository.IAnswerRepository;
import com.crio.xlido.Repository.IEventRepository;
import com.crio.xlido.Repository.IQuestionRepository;
import com.crio.xlido.Repository.IUserRepository;

public class AnswerService {

    private IQuestionRepository questionRepository;
    private IUserRepository iUserRepository;
    private IAnswerRepository answerRepository;
    private IEventRepository eventRepository;
    public AnswerService(IQuestionRepository questionRepository, IUserRepository iUserRepository,IAnswerRepository answerRepository,IEventRepository eventRepository) {
        this.questionRepository = questionRepository;
        this.iUserRepository = iUserRepository;
        this.answerRepository = answerRepository;
        this.eventRepository = eventRepository;
    }
     public Answers createAnswers(Answers answers){
        questionRepository.findById(answers.getQuestionId()).orElseThrow(()-> new RuntimeException("Question with an id "+answers.getQuestionId()+" does not exist"));
        iUserRepository.findById(answers.getUserId()).orElseThrow(()-> new RuntimeException("User with an id "+answers.getUserId()+" does not exist"));
        return answerRepository.save(answers);
     }

     public List<Question> orderList(Long eventId, String sortedBy) {
        // Ensure the event exists
        eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event with an id " + eventId + " does not exist"));
        
        // Retrieve questions associated with the event
        List<Question> questions = questionRepository.findByEventId(eventId);
        
        // Check if the list of questions is not null or empty
        if (questions != null && !questions.isEmpty()) {
            // Sort the list by popularity if specified
            if ("POPULAR".equalsIgnoreCase(sortedBy)) {
             questions.sort(Comparator.comparingInt(Question::getUpvote).reversed());
                //return "Questions sorted by popularity.";
            } else {
                // Reverse the list if no specific sorting criteria is provided
                Collections.reverse(questions);
              //  return "Questions sorted by default order.";
            }

        }
    
        return questions;
    }
    
}
