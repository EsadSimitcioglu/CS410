package Homework2;

import java.util.ArrayList;
import java.util.List;

public class Path {

    public StateStack iterate;
    public Stack stack;
    public List<String> road;
    public char initialStackSymbol;
    public boolean isValid = true;

    public Path(StateStack iterate, Stack stack,String initialStackSymbol) {
        this.iterate = iterate;
        this.stack = stack;
        this.initialStackSymbol = initialStackSymbol.charAt(0);
        road = new ArrayList<>();
        road.add(iterate.stateName);
    }

    public void findTransaction(char variable) {
        for (StateStackProps transaction : iterate.transactions) {
            if ((variable == transaction.variable || transaction.variable == 'ε' ) && (transaction.pop != initialStackSymbol && stack.pop(transaction.pop))) {
                stack.push(transaction.push);
                iterate = transaction.nextState;
                road.add(iterate.stateName);
                return;
            }
        }
        isValid = false;
    }

    public void startAndEndTransaction() {
        for (StateStackProps transaction : iterate.transactions) {
            if (transaction.variable == 'ε' &&  (transaction.pop == initialStackSymbol || transaction.push == initialStackSymbol)) {
                stack.pop(transaction.pop);
                stack.push(transaction.push);
                iterate = transaction.nextState;
                road.add(iterate.stateName);
            }
        }

    }
}
