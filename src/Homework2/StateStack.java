package Homework2;

import java.util.ArrayList;
import java.util.List;

public class StateStack {

    public String stateName;
    public List<StateStackProps> transactions;

    public StateStack(String stateName) {
        this.stateName = stateName;
        transactions = new ArrayList<>();
    }

    public void addTransaction(StateStackProps state){
        transactions.add(state);
    }

    public StateStack findTransaction(char variable, Stack stack){
        for(StateStackProps transaction : transactions){
            if(variable == transaction.variable && stack.pop(transaction.pop)){
                stack.push(variable);
                return transaction.nextState;
            }
        }
        return this;
    }

    public StateStack findEmptyTransaction(Stack stack){
        for(StateStackProps transaction : transactions){
            if(transaction.variable == 'ε' && stack.pop(transaction.pop)){
                return transaction.nextState;
            }
        }
        return this;
    }

}
