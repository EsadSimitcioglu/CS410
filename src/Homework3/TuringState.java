package Homework3;

import java.util.ArrayList;
import java.util.List;

public class TuringState {

    public String stateName;
    List<TuringStateProps> transactions;

    public TuringState(String stateName) {
        this.stateName = stateName;
        transactions = new ArrayList<>();
    }
}
