

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {

    private File day2;
    private ArrayList<String> passwords;
    private int validPasses = 0;
    private int prevMin = 0;
    private int prevMax = 0;
    private char prevKey = ' ';

    public DayTwo() {

        passwords = new ArrayList<>();
        day2 = new File("D:\\Advent_Of_code\\src\\main\\resources\\day2.txt");

        try{
            Scanner in = new Scanner(day2);

            while (in.hasNextLine()){
                passwords.add(in.nextLine());
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        passwords.forEach(this::validPass);



        System.out.println("Entries: " + passwords.size() + " Valid Passes: " + validPasses);
    }


    void validPass(String passcode){
        passcode = passcode.replaceAll("\\s+", "");
        System.out.println(passcode);
        int min = 0;
        int max = 0;
        int end = 0;
        char key = ' ';
        boolean valid = false;
        int occurrences = 0;
        ArrayList<Integer> minMax = new ArrayList<>();
        ArrayList<Character> passChars = new ArrayList<>();
        for (int i = 0; i < passcode.length(); i++) {
            if(Character.isDigit(passcode.charAt(i)) && (!Character.isDigit(passcode.charAt(i+1)))){
                minMax.add(Integer.parseInt(String.valueOf(passcode.charAt(i))));
            }else if(Character.isDigit(passcode.charAt(i)) && Character.isDigit(passcode.charAt(i+1))){
                minMax.add(Integer.parseInt(String.valueOf(passcode.charAt(i)) + String.valueOf(passcode.charAt(i+1))));
            }

            if(passcode.charAt(i) != '-' && passcode.charAt(i+1) == ':' && Character.isDigit(passcode.charAt(i-1))){
                key = passcode.charAt(i);
            }else if(passcode.charAt(i) == ':'){
                end = i+1;
                break;
            }
        }

        for(;end < passcode.length(); end++){
            passChars.add(passcode.charAt(end));
        }


        min = minMax.get(0);
        for (int i:
             minMax) {
            if(min < i){
                max = i;
            }
        }

        for (char e :
                passChars) {
            if(e == key){
                occurrences++;
            }
        }
        System.out.println("key: " + key + " occurrences: " + occurrences + " min: " + min +
                " PrevMin: " + prevMin + " max: " + max + " PrevMax: " + prevMax + " " + minMax +
                " ValidPasses: " + validPasses);
        if(occurrences != 0){
            if(occurrences >= min && occurrences <= max){
                validPasses++;
                valid = true;
            }
        }

        int oldOccurrences = 0;

        if(prevKey != ' '){
            for (char e:
                 passChars) {
                if(e == prevKey) {
                    oldOccurrences++;
                }
            }
        }

        if(oldOccurrences != 0 && !valid){
            if(oldOccurrences >= prevMin && oldOccurrences <= prevMax){
                validPasses++;
            }
        }

        prevMin = min;
        prevMax = max;
        prevKey = key;

    }
}
