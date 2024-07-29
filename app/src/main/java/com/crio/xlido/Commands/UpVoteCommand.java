package com.crio.xlido.Commands;

import java.util.List;
import com.crio.xlido.Sevices.QuestionService;


public class UpVoteCommand implements ICommand {

    private final QuestionService questionServices;

    public UpVoteCommand(QuestionService questionServices){
        this.questionServices=questionServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub

        Long questionID= Long.valueOf(tokens.get(1));
        Long userID= Long.valueOf(tokens.get(2));

        // questionServices.upVoteContest(questionID, userID);
        
    }
    
}
