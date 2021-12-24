package Homework3;

public class TuringStateProps {

    public char variable;
    public TuringState nextState;

    public TuringStateProps(String variable, TuringState nextState) {
        this.variable = variable.charAt(0);
        this.nextState = nextState;
    }
}
