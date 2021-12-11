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

    public StateStack findTransaction(char variable){
        for(int i = 0;i<transactions.size();i++){
            if(variable == transactions.get(i).variable){
                return transactions.get(i).nextState;
            }
        }
        return this;
    }

    public StateStack findEmptyTransaction(){
        for(StateStackProps transaction : transactions){
            if(transaction.variable == 'ε'){
                return transaction.nextState;
            }
        }
        return this;
    }

}
