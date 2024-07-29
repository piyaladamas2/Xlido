package com.crio.xlido.Commands;

import java.util.List;
import com.crio.xlido.Entities.Question;

import com.crio.xlido.Sevices.QuestionService;

public class AddQuestionCommand implements ICommand {

    private final QuestionService questionService;

    public AddQuestionCommand(QuestionService questionServices){
        this.questionService= questionServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub

        String content= tokens.get(1);
        Long userID= Long.valueOf(tokens.get(2));
        Long eventID=Long.valueOf(tokens.get(3));
        
    Question question = new Question(content, userID, eventID);
       Question result= questionService.createQuestion(question);
   

        
    //     Question questions= questionService.addQuestion(content,userID,eventID);

        System.out.println("Question ID: "+ result.getId());
    // }
    
}
}
