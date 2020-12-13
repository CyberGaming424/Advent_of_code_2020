import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {


    private File day1;
    private ArrayList<Integer> expenses;


    public DayOne()  {

        try {
            day1 = new File("D:\\Advent_Of_code\\src\\main\\resources\\day1.txt");
            Scanner in = new Scanner(day1);
            expenses = new ArrayList<Integer>();
            int first = 0;
            int second = 0;
            int third = 0;
            while (in.hasNext()) {
                expenses.add(in.nextInt());
            }

            for (int i = 0; i < expenses.size(); i++) {
                for (int e = 0; e < expenses.size(); e++) {
                    for(int f = 0; f < expenses.size(); f++){
                        if (expenses.get(i) != expenses.get(e) && expenses.get(i) != f) {
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

