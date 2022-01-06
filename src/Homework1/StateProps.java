package Homework1;

public class StateProps {

    public char variable;
    public State nextState;

    public StateProps(String variable, State nextState) {
        this.variable = variable.charAt(0);
        this.nextState = nextState;
    }
}
