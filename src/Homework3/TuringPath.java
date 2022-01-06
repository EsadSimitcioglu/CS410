package Homework3;

import java.util.List;

public class TuringPath {

    public TuringState iterate;
    public Tape tape;
    public List<String> road;
    public String blankTapeSymbol;
    public boolean valid;

    public TuringPath(TuringState iterate, Tape tape, String blankTapeSymbol) {
        this.iterate = iterate;
        this.tape = tape;
        this.blankTapeSymbol = blankTapeSymbol;
    }

    public void findPath(String input){};

    public void findTransaction(String input){};

    public void startAndEndTransaction(){};

    @Override
    public String toString() {
        return "TuringPath{" +
                "iterate=" + iterate +
                ", tape=" + tape +
                ", road=" + road +
                ", blankTapeSymbol='" + blankTapeSymbol + '\'' +
                ", valid=" + valid +
                '}';
    }
}
