package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Tape {

    public int TapeHeadIndex;
    public List<String> tape;
    public TuringState acceptState;
    public TuringState rejectState;
    public String blankSymbol;

    public Tape(int tapeHeadIndex, TuringState acceptState, TuringState rejectState, String blankSymbol) {
        TapeHeadIndex = tapeHeadIndex;
        this.tape = new ArrayList<>();
        this.acceptState = acceptState;
        this.rejectState = rejectState;
        this.blankSymbol = blankSymbol;
    }
}
