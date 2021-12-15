import Homework2.Path;
import Homework2.Stack;
import Homework2.StateStack;
import Homework2.StateStackProps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {


    public static void Homework1(){
        int stateNumber;
        int variableNumber;
        int numberOfGoalStates;
        List<String> stateNames;
        List<String> goalStateNames;
        List<State> states = new ArrayList<>();

        try {
            File myObj = new File("input.txt");
            FileWriter myWriter = new FileWriter("output.txt");
            Scanner myReader = new Scanner(myObj);
            stateNumber = Integer.parseInt(myReader.nextLine());
            variableNumber = Integer.parseInt(myReader.nextLine());
            numberOfGoalStates = Integer.parseInt(myReader.nextLine());
            stateNames = Arrays.asList(myReader.nextLine().split(" "));
            for (String stateName : stateNames)
                states.add(new State(stateName));
            goalStateNames = Arrays.asList(myReader.nextLine().split(" "));
            for (int i = 0; i <= stateNumber * variableNumber; i++) {
                String[] transactions = myReader.nextLine().split(" ");
                for (State state : states) {
                    if (state.stateName.equals(transactions[0]))
                        state.addTransaction(new StateProps(transactions[1], states.get(stateNames.indexOf(transactions[2]))));
                }
            }
            while (myReader.hasNextLine()) {
                State iterate = states.get(0);
                String line = myReader.nextLine();
                for (var i = 0; i < line.length(); i++) {
                    iterate = iterate.findTransaction(line.charAt(i));
                    myWriter.write(iterate.stateName + "  ");
                }
                myWriter.write("\n");
                if (goalStateNames.contains(iterate.stateName))
                    myWriter.write("Accepted\n");
                else
                    myWriter.write("Rejected\n");
            }
            myWriter.close();
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Homework2(){
        int variableNumber;
        int inputNumber;
        int stackNumber;
        int numberOfGoalStates;
        int stateNumber;
        List<String> stateNames;
        String startState;
        List<String> goalStateNames;
        List<StateStack> states = new ArrayList<>();
        List<String> stackVariable = new ArrayList<>();
        String initialStackSymbol;
        List<String> inputs = new ArrayList<>();
        List<Path> paths = new ArrayList<>();

        try {
            File myObj = new File("input.txt");
            FileWriter myWriter = new FileWriter("output.txt");
            Scanner myReader = new Scanner(myObj);
            inputNumber = Integer.parseInt(myReader.nextLine());
            stackNumber = Integer.parseInt(myReader.nextLine());
            numberOfGoalStates = Integer.parseInt(myReader.nextLine());
            stateNumber = Integer.parseInt(myReader.nextLine());

            stateNames = Arrays.asList(myReader.nextLine().split(" "));
            for (String stateName : stateNames)
                states.add(new StateStack(stateName));

            startState = myReader.nextLine();

            goalStateNames = Arrays.asList(myReader.nextLine().split(" "));
            stackVariable = Arrays.asList(myReader.nextLine().split(" "));
            initialStackSymbol = myReader.nextLine();
            inputs = Arrays.asList(myReader.nextLine().split(" "));

            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] transactions = line.split(" ");
                if(transactions.length > 1){
                    for (StateStack state : states) {
                        if (state.stateName.equals(transactions[0]))
                            state.addTransaction(new StateStackProps(transactions[1], states.get(stateNames.indexOf(transactions[4])), transactions[2].charAt(0) , transactions[3].charAt(0)));
                    }
                }
                else {

                    myWriter.write("New Input\n");

                    StateStack iterate = states.get(stateNames.indexOf(startState));
                    Stack stack = new Stack(initialStackSymbol);
                    paths.add(new Path(iterate,stack,initialStackSymbol));
                    paths.get(paths.size()-1).findPath(line);

                    Path path = paths.get(paths.size()-1);

                    for(String stop : path.road) {
                        myWriter.write(stop + "\t");
                    }


                    if (goalStateNames.contains(path.iterate.stateName))
                        myWriter.write("(Accepted)\n");
                    else
                        myWriter.write("(Rejected)\n");

                    myWriter.write("\n");

                    myWriter.write("Possible Paths : ");
                    possbilePaths(path,myWriter,goalStateNames);

                    myWriter.write("\n");


                }
            }

            for(StateStack state : states){
                System.out.println(state.stateName + " ");
                for(StateStackProps props : state.transactions)
                    System.out.println(props);
            }

            myWriter.close();
            myReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void possbilePaths(Path p, FileWriter myWriter,List<String> goalStateNames) {
        try{
            if(p.innerPath != null){
                myWriter.write("\n");
                for (String innerStop : p.innerPath.road)
                    myWriter.write("\t" + innerStop + " ");
                    if (goalStateNames.contains(p.innerPath.iterate.stateName))
                        myWriter.write("(Accepted)\n");
                    else
                        myWriter.write("(Rejected)\n");

                    possbilePaths(p.innerPath, myWriter,goalStateNames);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main (String args[]) {
        Homework2();
    }
}
