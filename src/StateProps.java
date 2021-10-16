public class StateProps {

    char variable;
    State nextState;

    public StateProps(String variable, State nextState) {
        this.variable = variable.charAt(0);
        this.nextState = nextState;
    }
}
