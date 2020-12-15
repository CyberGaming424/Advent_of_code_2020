/**
 * @author CyberGaming424
 *
 * Description:
 * These are my solutions for the Advent Of Code for 2020
 * I didn't completly make these my self.
 * I had to get a bit of help from the web but I was able to make them into my own.
 * For more info see - https://adventofcode.com/
 */
public class Main {

    public static void main(String[] args) {

        if(args.length > 0) {
            switch (Integer.parseInt(args[0])) {
                case 1:
                    new DayOne();
                    break;
                case 2:
                    if (args[1] != null) {
                        if (args[1].equalsIgnoreCase("true"))
                            new DayTwo(true);
                        else
                            new DayTwo(false);
                    } else
                        System.out.println("Invalid arguments, argument 2 must be either false for part 1 or true for part 2!");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid argument!");
                    System.out.println("Usage: -[Program 1 - 25]");
            }
        }
        //new DayOne();
        //new DayTwo(false);
        //new DayThree();
    }

}
