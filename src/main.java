import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main (String args[]) {

        int stateNumber = 0;
        int variableNumber = 0;
        int numberOfGoalStates = 0;
        List<String> stateNames = new ArrayList<>();
        List<String> goalStateNames = new ArrayList<>();
        List<State> states = new ArrayList<>();

        try {
            File myObj = new File("input2.txt");
            Scanner myReader = new Scanner(myObj);
            stateNumber = Integer.parseInt(myReader.nextLine());
            variableNumber = Integer.parseInt(myReader.nextLine());
            numberOfGoalStates = Integer.parseInt(myReader.nextLine());
            stateNames = Arrays.asList(myReader.nextLine().split(" "));
            for (String stateName : stateNames) {
                states.add(new State(stateName));
            }
            goalStateNames = Arrays.asList(myReader.nextLine().split(" "));
            for (int i = 0; i <= stateNumber * variableNumber; i++) {
                String[] transactions = myReader.nextLine().split(" ");
                for (State state : states) {
                    if (state.stateName.equals(transactions[0]))
                        state.addTransaction(new StateProps(transactions[1], states.get(stateNames.indexOf(transactions[2]))));
                }
            }
            FileWriter myWriter = new FileWriter("output.txt");

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
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
