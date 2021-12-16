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

}
