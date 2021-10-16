import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main (String args[]) {

        int stateNumber = 0;
        int variableNumber = 0;
        List<String> lines = new ArrayList<>();
        List<String> stateNames = new ArrayList<>();
        List<String> goalStateNames = new ArrayList<>();
        List<State> states = new ArrayList<>();
        var linesOfCount = 0;
        

        try {
            File myObj = new File("input2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
                String[] transactions = data.split(" ");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        for(String line : lines){
            if(linesOfCount==0){
                stateNumber = Integer.parseInt(line);
            }
            if(linesOfCount==1){
                variableNumber = Integer.parseInt(line);
            }
            if(linesOfCount==3){
                stateNames = Arrays.asList(line.split(" "));
                for (String stateName : stateNames) {
                    states.add(new State(stateName));
                }
            }
            if(linesOfCount==4){
                goalStateNames = Arrays.asList(line.split(" "));
            }
            if(linesOfCount>=6 && linesOfCount < 6+stateNumber*variableNumber){
                String[] transactions = line.split(" ");
                for (State state : states) {
                    if (state.stateName.equals(transactions[0])) {
                        //System.out.println(state.stateName);
                        state.addTransaction(new StateProps(transactions[1],states.get(stateNames.indexOf(transactions[2]))));
                    }
                }
            }
            if(linesOfCount >= 6+stateNumber*variableNumber && linesOfCount>6){
                State iterate = states.get(0);
                for(var i = 0;i<line.length();i++){
                    iterate = iterate.findTransaction(line.charAt(i));
                    System.out.print(iterate.stateName + "  ");
                }
                System.out.println();
                if(goalStateNames.contains(iterate.stateName)){
                    System.out.println("Accepted");
                }
                else {
                    System.out.println("Rejected");
                }
            }
            linesOfCount++;
        }
    }
}
