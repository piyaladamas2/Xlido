package com.crio.xlido.Commands;
import java.util.List;

public interface ICommand {
    void invoke(List<String> tokens);
}
