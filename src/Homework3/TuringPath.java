package Homework3;


import java.util.ArrayList;
import java.util.List;

public class TuringPath {

    public TuringState iterate;
    public Tape tape;
    public List<String> road;
    public char blankTapeSymbol;
    public boolean isValid = false;

    public TuringPath(TuringState iterate, Tape tape, char blankTapeSymbol) {
        this.iterate = iterate;
        this.tape = tape;
        this.blankTapeSymbol = blankTapeSymbol;
        this.road = new ArrayList<>();
    }

    public void findPath(String input){}

    public void findTransaction(String input) {}

    public void startAndEndTransaction() {}

    @Override
    public String toString() {
        return "TuringPath{" +
                "iterate=" + iterate +
                ", tape=" + tape +
                ", road=" + road +
                ", blankTapeSymbol=" + blankTapeSymbol +
                ", isValid=" + isValid +
                '}';
    }
}
