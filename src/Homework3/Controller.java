package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Tape inputTape;
    public TuringState acceptState;
    public TuringState rejectState;
    public List<String> inputAlphabet;
    public List<String> tapeAlphabet;

    public List<String> path;

    public Controller() {
        this.inputTape = new Tape(0);
        this.inputAlphabet = new ArrayList<>();
        this.tapeAlphabet = new ArrayList<>();
        this.path = new ArrayList<>();
    }


    public boolean findTransaction(TuringState iterate){
        path.add(iterate.stateName);
        while(inputTape.tapeHeadIndex < inputTape.tapeVariables.size()){
            for(int i = 0;i<iterate.transactions.size();i++){
                if(inputTape.tapeVariables.get(inputTape.tapeHeadIndex) == iterate.transactions.get(i).inputVariable){
                    inputTape.tapeVariables.set(inputTape.tapeHeadIndex, iterate.transactions.get(i).tapeVariable);
                    if(iterate.transactions.get(i).rotate == 'R')
                        inputTape.tapeHeadIndex++;
                    else
                        inputTape.tapeHeadIndex--;
                    iterate = iterate.transactions.get(i).nextState;
                    path.add(iterate.stateName);
                    break;
                }
            }
            if(iterate.equals(acceptState))
                return true;
            if(iterate.equals((rejectState)))
                return false;
        }
        return iterate.equals(acceptState);
    }



}
