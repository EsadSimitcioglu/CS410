import Homework1.State;
import Homework1.StateProps;
import Homework2.PDAPath;
import Homework2.PDAState;
import Homework2.PDAStateProps;
import Homework2.Stack;
import Homework3.Controller;
import Homework3.TuringState;
import Homework3.TuringStateProps;

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
        List<PDAState> states = new ArrayList<>();
        List<String> stackVariable = new ArrayList<>();
        String initialStackSymbol;
        List<String> inputs = new ArrayList<>();
        List<PDAPath> paths = new ArrayList<>();

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
                states.add(new PDAState(stateName));

            startState = myReader.nextLine();

            goalStateNames = Arrays.asList(myReader.nextLine().split(" "));
            stackVariable = Arrays.asList(myReader.nextLine().split(" "));
            initialStackSymbol = myReader.nextLine();
            inputs = Arrays.asList(myReader.nextLine().split(" "));

            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] transactions = line.split(" ");
                if(transactions.length > 1){
                    for (PDAState state : states) {
                        if (state.stateName.equals(transactions[0]))
                            state.addTransaction(new PDAStateProps(transactions[1], states.get(stateNames.indexOf(transactions[4])), transactions[2].charAt(0) , transactions[3].charAt(0)));
                    }
                }
                else {

                    myWriter.write("New Input\n");

                    PDAState iterate = states.get(stateNames.indexOf(startState));
                    Stack stack = new Stack(initialStackSymbol);
                    paths.add(new PDAPath(iterate,stack,initialStackSymbol));
                    paths.get(paths.size()-1).findPath(line);

                    PDAPath path = paths.get(paths.size()-1);

                    for(String stop : path.road) {
                        myWriter.write(stop + "\t");
                    }

                    if (goalStateNames.contains(path.iterate.stateName) && path.isValid)
                        myWriter.write("(Accepted)\n");
                    else
                        myWriter.write("(Rejected)\n");

                    myWriter.write("\n");

                    myWriter.write("Possible Paths : ");
                    possbilePaths(path,myWriter,goalStateNames);

                    myWriter.write("\n");


                }
            }

            for(PDAState state : states){
                System.out.println(state.stateName + " ");
                for(PDAStateProps props : state.transactions)
                    System.out.println(props);
            }

            myWriter.close();
            myReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void possbilePaths(PDAPath p, FileWriter myWriter,List<String> goalStateNames) {
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

    public static void Homework3(){
        int stateNumber;
        int variableNumber;
        int numberOfGoalStates;
        int tapeVariableNumber;
        List<String> stateNames;
        List<String> goalStateNames;
        List<TuringState> states = new ArrayList<>();
        String acceptState;
        String rejectState;
        String startState;
        String blankSymbol;
        Controller controller = new Controller();
        List<String> tapeAlphabet;
        List<String> inputAlphabet;

        try {
            File myObj = new File("input.txt");
            FileWriter myWriter = new FileWriter("output.txt");
            Scanner myReader = new Scanner(myObj);
            variableNumber = Integer.parseInt(myReader.nextLine());
            tapeVariableNumber = Integer.parseInt(myReader.nextLine());
            stateNumber = Integer.parseInt(myReader.nextLine());
            stateNames = Arrays.asList(myReader.nextLine().split(" "));
            for (String stateName : stateNames)
                states.add(new TuringState(stateName));
            startState = myReader.nextLine();
            acceptState = myReader.nextLine();
            rejectState = myReader.nextLine();
            blankSymbol = myReader.nextLine();
            tapeAlphabet  = Arrays.asList(myReader.nextLine().split(" "));
            controller.tapeAlphabet.addAll(tapeAlphabet);
            inputAlphabet  = Arrays.asList(myReader.nextLine().split(" "));
            controller.inputAlphabet.addAll(inputAlphabet);
            for (int i = 0; i < (stateNumber-2) * (variableNumber+tapeVariableNumber); i++) {
                String[] transactions = myReader.nextLine().split(" ");
                for (TuringState state : states) {
                    if (state.stateName.equals(transactions[0]))
                        state.addTransaction(new TuringStateProps(transactions[1].charAt(0), transactions[2].charAt(0), transactions[3].charAt(0), states.get(stateNames.indexOf(transactions[4]))));
                }
            }

            TuringState iterate = states.get(0);

            for(TuringState state : states){
                if(state.stateName.equals(acceptState))
                    controller.acceptState = state;
                else if(state.stateName.equals(rejectState))
                    controller.rejectState = state;
                else if(state.stateName.equals(startState))
                    iterate = state;
            }


            while (myReader.hasNextLine()) {

                String line = myReader.nextLine();
                for(var i =0;i<line.length();i++)
                {
                    controller.inputTape.tapeVariables.add(line.charAt(i));
                }

                controller.inputTape.tapeVariables.add(blankSymbol.charAt(0));
                controller.inputTape.tapeVariables.add(blankSymbol.charAt(0));

                System.out.println(line);
                System.out.println(controller.path + " | " +  controller.findTransaction(iterate));

            }
            myWriter.close();
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main (String args[]) {
        Homework3();
    }
}
