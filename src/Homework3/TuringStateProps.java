package Homework3;

public class TuringStateProps {

    public Character inputVariable;
    public Character tapeVariable;
    public Character rotate;
    public TuringState nextState;

    public TuringStateProps(Character inputVariable, Character tapeVariable, Character rotate, TuringState nextState) {
        this.inputVariable = inputVariable;
        this.tapeVariable = tapeVariable;
        this.rotate = rotate;
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "TuringStateProps{" +
                "inputVariable='" + inputVariable + '\'' +
                ", tapeVariable='" + tapeVariable + '\'' +
                ", rotate='" + rotate + '\'' +
                ", nextState=" + nextState.stateName +
                '}';
    }
}
