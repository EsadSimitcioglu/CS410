package Homework3;

import java.util.ArrayList;
import java.util.List;

public class Tape {

    public int tapeHeadIndex;
    public List<Character> tapeVariables;


    public Tape(int tapeHeadIndex){
        this.tapeHeadIndex = tapeHeadIndex;
        this.tapeVariables = new ArrayList<>();
    }

}
