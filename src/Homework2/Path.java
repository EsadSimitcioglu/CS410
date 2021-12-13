package Homework2;

import java.util.ArrayList;
import java.util.List;

public class Path {

    public StateStack iterate;
    public Stack stack;
    public List<String> road;
    public char initialStackSymbol;
    public boolean isValid = false;
    public int counter = 0;

    public List<Path> differentPaths;

    public Path(StateStack iterate, Stack stack,String initialStackSymbol) {
        this.iterate = iterate;
        this.stack = stack;
        this.initialStackSymbol = initialStackSymbol.charAt(0);
        road = new ArrayList<>();
        differentPaths = new ArrayList<>();
        road.add(iterate.stateName);
    }

    public void findPath(String input){

        startAndEndTransaction();
        findTransaction(input);
        if(isValid)
            startAndEndTransaction();
    }

    public void findTransaction(String input) {
        for (var i = 0; i < input.length(); i++) {
            counter = 0;
            isValid = false;
            for (StateStackProps transaction : iterate.transactions) {
                if ((input.charAt(i) == transaction.variable || transaction.variable == 'ε') && (transaction.pop != initialStackSymbol && stack.pop(transaction.pop))) {
                    stack.push(transaction.push);
                    iterate = transaction.nextState;
                    road.add(iterate.stateName);
                    isValid = true;
                    counter++;

                    if (counter == 2) {
                        differentPaths.add(new Path(iterate, stack, Character.toString(initialStackSymbol)));
                        differentPaths.get(differentPaths.size() - 1).findPath(input.substring(i+1));
                        counter = 0;
                    }
                }
            }
        }
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

    @Override
    public String toString() {
        return "Path{" +
                "iterate=" + iterate +
                ", stack=" + stack +
                ", road=" + road +
                ", initialStackSymbol=" + initialStackSymbol +
                ", isValid=" + isValid +
                ", counter=" + counter +
                '}';
    }
}
