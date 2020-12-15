import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author CyberGaming424
 * Description:
 * This is the solution for day 1 Report Repair.
 * For more info see - https://adventofcode.com/2020/day/1
 */
class DayOne {


    private File day1;
    private ArrayList<Integer> expenses;


    public DayOne()  {

        try {
            day1 = new File("src/main/resources/day1.txt");
            Scanner in = new Scanner(day1);
            expenses = new ArrayList<>();
            int first = 0;
            int second = 0;
            int third = 0;
            while (in.hasNext()) {
                expenses.add(in.nextInt());
            }

            for (int i = 0; i < expenses.size(); i++) {
                for (int e = 0; e < expenses.size(); e++) {
                    for(int f = 0; f < expenses.size(); f++){
                        if (!(expenses.get(i).equals(expenses.get(e)) && expenses.get(i).equals(f))) {
                            if ((expenses.get(i) + expenses.get(e) + expenses.get(f)) == 2020) {
                                first = expenses.get(i);
                                second = expenses.get(e);
                                third = expenses.get(f);
                            }
                        }
                    }
                }
            }

            System.out.println(first * second * third);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

}

