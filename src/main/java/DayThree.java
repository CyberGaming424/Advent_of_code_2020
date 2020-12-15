import java.util.ArrayList;
/**
 * @author CyberGaming424
 * Description:
 * This is the solution for day 3 Toboggan Trajectory.
 * For more info see - https://adventofcode.com/2020/day/3
 */
class DayThree {

    private final ArrayList<String> lines = Utils.Util.lines("src/main/resources/day3.txt");

    /**
     * Part 1 constructor
     * @param dy - is your rise
     * @param dx - is your run
    */
    public DayThree(int dy, int dx){
        System.out.println(countTrees(lines, dy, dx));
    }

    /**
     * Part 2 constructor
     */
    public DayThree(){
        int result = 1;
        int[][] slopes = new int[][]{
                {1, 1},
                {3, 1},
                {5, 1},
                {7, 1},
                {1, 2}
        };

        for (int[] slope : slopes) {
            result *= countTrees(lines, slope[1], slope[0]);
        }

        System.out.println(result);
    }

    private int countTrees(ArrayList<String> input, int dy, int dx){
        final int height = input.size();
        final int width = input.get(dy).length();

        int y = dy;
        int x = dx % width;
        int result = 0;

        while (y < height) {
            if (input.get(y).charAt(x) == '#') {
                result += 1;
            }
            y = y + dy;
            x = (x + dx) % width;
        }

        return result;
    }


}
