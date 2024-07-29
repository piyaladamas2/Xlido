package com.crio.xlido.Commands;

import java.util.List;
import com.crio.xlido.Sevices.QuestionService;


public class ReplyQuestionCommand implements ICommand {

    private final QuestionService questionServices;
    public ReplyQuestionCommand(QuestionService questionServices){
        this.questionServices= questionServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String content= tokens.get(1);
        Long questionID= Long.valueOf(tokens.get(2));
        Long userID= Long.valueOf(tokens.get(3));

        // questionServices.replyQuestion(content, questionID, userID);
    }
    
}
