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

    public Path innerPath;

    public Path(StateStack iterate, Stack stack,String initialStackSymbol) {
        this.iterate = iterate;
        this.stack = stack;
        this.initialStackSymbol = initialStackSymbol.charAt(0);
        road = new ArrayList<>();
        road.add(iterate.stateName);
    }

    public void findPath(String input){

        startAndEndTransaction();
        findTransaction(input);
        if(this.isValid)
            startAndEndTransaction();
    }

    public void findTransaction(String input) {
        for (var i = 0; i < input.length(); i++) {
            counter = 0;
            this.isValid = false;
            Stack prevStack = new Stack(stack.initialVariable);
            prevStack.stack.addAll(stack.stack);

            for (StateStackProps transaction : this.iterate.transactions) {
                if ((input.charAt(i) == transaction.variable || transaction.variable == 'ε') ) {
                    System.out.println(counter   +  " | " + transaction + " | " + input.charAt(i));
                    counter++;
                    if (counter >= 2) {
                        this.innerPath = new Path(iterate, prevStack, Character.toString(initialStackSymbol));
                        this.innerPath.road.remove(0);
                        this.innerPath.road.addAll(road.subList(0,road.size()-1));
                        if((transaction.pop != innerPath.initialStackSymbol && innerPath.stack.pop(transaction.pop))){
                            this.innerPath.road.add(transaction.nextState.stateName);
                            this.innerPath.findPath(input.substring(i+1));
                        }

                    }
                    else if((transaction.pop != this.initialStackSymbol && this.stack.pop(transaction.pop))){
                        this.stack.push(transaction.push);
                        this.iterate = transaction.nextState;
                        this.road.add(this.iterate.stateName);
                        this.isValid = true;
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

    public void setRoad(List<String> road) {
        this.road = road;
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
