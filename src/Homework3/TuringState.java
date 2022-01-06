package Homework3;

import java.util.ArrayList;
import java.util.List;

public class TuringState {

    public String stateName;
    public List<TuringStateProps> transactions = new ArrayList<>();

    public TuringState(String stateName){
        this.stateName = stateName;
    }

    public void addTransaction(TuringStateProps state){
        transactions.add(state);
    }



    @Override
    public String toString() {
        return "TuringState{" +
                "stateName='" + stateName + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
