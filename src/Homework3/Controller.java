package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public Tape inputTape;
    public TuringState acceptState;
    public TuringState rejectState;
    public String blankSymbol;
    public List<String> inputAlphabet;
    public List<String> tapeAlphabet;

    public Controller() {
        this.inputTape = new Tape(0);
        this.inputAlphabet = new ArrayList<>();
        this.tapeAlphabet = new ArrayList<>();
    }


    public boolean findTransaction(TuringState iterate){
        System.out.print(iterate.stateName + " ");
        while(inputTape.tapeHeadIndex != inputTape.tapeVariables.size()){
            for(int i = 0;i<iterate.transactions.size();i++){
                if(inputTape.tapeVariables.get(inputTape.tapeHeadIndex) == iterate.transactions.get(i).inputVariable){
                    inputTape.tapeVariables.set(inputTape.tapeHeadIndex, iterate.transactions.get(i).tapeVariable);
                    if(iterate.transactions.get(i).rotate == 'R')
                        inputTape.tapeHeadIndex++;
                    else
                        inputTape.tapeHeadIndex--;
                    iterate = iterate.transactions.get(i).nextState;
                    System.out.print(iterate.stateName + " ");
                    break;
                }
            }
        }
        return iterate.equals(acceptState);
    }



}
