package com.crio.xlido.Commands;

import java.util.List;
import com.crio.xlido.Sevices.QuestionService;


public class ListQuestionCommand implements ICommand{

    private final QuestionService questionServices;

    public ListQuestionCommand(QuestionService questionServices){
        this.questionServices= questionServices;
    }

    public void invoke(List<String> tokens) {
        Long eventID = Long.valueOf(tokens.get(1));
        String order = tokens.get(2); // Change from tokens.get(1) to tokens.get(2)
    
        // questionServices.listOfQuestion(eventID, order);
    }
    
}
