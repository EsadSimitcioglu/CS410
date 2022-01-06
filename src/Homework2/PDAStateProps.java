package Homework2;

public class PDAStateProps {

    public char variable;
    public PDAState nextState;
    public char pop;
    public char push;

    public PDAStateProps(String variable, PDAState nextState, char pop, char push) {
        this.variable = variable.charAt(0);
        this.nextState = nextState;
        this.pop = pop;
        this.push = push;
    }

    @Override
    public String toString() {
        return "PDAStateProps{" +
                "variable=" + variable +
                ", nextState=" + nextState.stateName +
                ", pop=" + pop +
                ", push=" + push +
                '}';
    }
}
