package Homework1;

import java.util.ArrayList;
import java.util.List;

public class State {

    public String stateName;
    List<StateProps> transactions;

    public State(String stateName) {
        this.stateName = stateName;
        transactions = new ArrayList<>();
    }

    public void addTransaction(StateProps state){
        transactions.add(state);
    }

    public State findTransaction(char variable){
        for(int i = 0;i<transactions.size();i++){
            if(variable == transactions.get(i).variable){
                return transactions.get(i).nextState;
            }
        }
        return this;
    }
}
