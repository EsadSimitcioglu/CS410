package Homework2;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    public String[] variables;
    public List<Character> stack;
    public String initialVariable;

    public Stack(int variableSize, String initialVariable) {
        this.variables = new String[variableSize];
        this.initialVariable = initialVariable;
        this.stack = new ArrayList<Character>();
    }

    public void push(char variable){

        if(variable == 'ε')
            return;

        stack.add(variable);
    }

    public boolean pop(char pop){


        if(pop == 'ε')
            return true;

        if(stack.size() == 0 || stack.get(stack.size()-1) != pop )
            return false;

        stack.remove(stack.size()-1);

        return true;

    }


}
