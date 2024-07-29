package com.crio.xlido.Sevices;


import java.util.List;
import com.crio.xlido.Entities.Question;
import com.crio.xlido.Repository.IEventRepository;
import com.crio.xlido.Repository.IQuestionRepository;
import com.crio.xlido.Repository.IUserRepository;

public class QuestionService {

    private IQuestionRepository questionRepository;
    private IEventRepository iEventRepository;
    private IUserRepository iUserRepository;

    
    
    public QuestionService(IQuestionRepository questionRepository,
            IEventRepository iEventRepository, IUserRepository iUserRepository) {
        this.questionRepository = questionRepository;
        this.iEventRepository = iEventRepository;
        this.iUserRepository = iUserRepository;
    }


    public Question createQuestion(Question question){
        iEventRepository.findById(question.getEventId()).orElseThrow(()-> new RuntimeException("Event with an id "+question.getEventId()+" does not exist"));
        iUserRepository.findById(question.getUserId()).orElseThrow(()-> new RuntimeException("User with an id "+question.getUserId()+" does not exist"));
      return questionRepository.save(question);
    }


    public Question deleteQuestion(Long quesId,Long userId){
       Question question = questionRepository.findById(quesId).orElseThrow(()-> new RuntimeException("Question with an id "+quesId+" does not exist"));
        iUserRepository.findById(userId).orElseThrow(()-> new RuntimeException("User with an id "+userId+" does not exist"));
        if(question.getUserId()!= userId) throw new RuntimeException("User with an id "+userId+" is not an author of question with an id "+quesId);
        return questionRepository.removeQuestion(question.getId());
        
              
    }

    public Question upvoteQuestions(Long quesId,Long userId){
        Question question = questionRepository.findById(quesId).orElseThrow(()-> new RuntimeException("Question with an id "+quesId+" does not exist"));
        iUserRepository.findById(userId).orElseThrow(()-> new RuntimeException("User with an id "+userId+" does not exist"));
        List<Long> votedUserList = question.getVoted_userId();
        for(Long id:votedUserList){
            if(id == userId) throw new RuntimeException("User with an id "+userId+" has already upvoted a question with an id "+quesId);
        }
        votedUserList.add(userId);
          Integer count = question.getUpvote();
        question.setUpvote(++count);
        question.setVoted_userId(votedUserList);
       Question question2 = questionRepository.save(question);
        return question2;
    }
}

