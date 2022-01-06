package Homework2;

import java.util.ArrayList;
import java.util.List;

public class PDAState {

    public String stateName;
    public List<PDAStateProps> transactions;

    public PDAState(String stateName) {
        this.stateName = stateName;
        transactions = new ArrayList<>();
    }

    public void addTransaction(PDAStateProps state){
        transactions.add(state);
    }

    public PDAState findTransaction(char variable, Stack stack){
        for(PDAStateProps transaction : transactions){
            if(variable == transaction.variable && stack.pop(transaction.pop)){
                stack.push(variable);
                return transaction.nextState;
            }
        }
        return this;
    }

    public PDAState findEmptyTransaction(Stack stack){
        for(PDAStateProps transaction : transactions){
            if(transaction.variable == 'ε' && stack.pop(transaction.pop)){
                return transaction.nextState;
            }
        }
        return this;
    }

}
