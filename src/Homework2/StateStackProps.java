package Homework2;

public class StateStackProps {

    public char variable;
    public StateStack nextState;
    public char pop;
    public char push;

    public StateStackProps(String variable, StateStack nextState, char pop, char push) {
        this.variable = variable.charAt(0);
        this.nextState = nextState;
        this.pop = pop;
        this.push = push;
    }

    @Override
    public String toString() {
        return "StateStackProps{" +
                "variable=" + variable +
                ", nextState=" + nextState.stateName +
                ", pop=" + pop +
                ", push=" + push +
                '}';
    }
}
