

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

    private String[] lines;

    public DayTwo(boolean partTwo) {

        try {
            lines = Files.lines(Path.of("D:\\Advent_Of_code\\src\\main\\resources\\day2.txt")).toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            lines = new String[0];
        }

        if(!partTwo)
            partOne(lines);
        else
            partTwo(lines);

    }

    public static void partOne(String[] lines) {
        int validCount = 0;
        String regex = "(\\d+)-(\\d+)\\s+(\\w):\\s+(\\w+)";
        for (String line : lines) {
            Matcher m = Pattern.compile(regex).matcher(line);
            if (m.find()) {
                int min = Integer.parseInt(m.group(1));
                int max = Integer.parseInt(m.group(2));
                String req = m.group(3);
                String pw = m.group(4);
                Matcher findOccurrences = Pattern.compile(req).matcher(pw);
                int count = 0;
                while (findOccurrences.find()) {
                    ++count;
                }
                if (count >= min && count <= max) {
                    ++validCount;
                }
            }
        }
        System.out.println(validCount);
    }

    public static void partTwo(String[] lines) {
        int validCount = 0;
        String regex = "(\\d+)-(\\d+)\\s+(\\w):\\s+(\\w+)";
        for (String line : lines) {
            Matcher m = Pattern.compile(regex).matcher(line);
            if (m.find()) {
                int pos1 = Integer.parseInt(m.group(1)) - 1;
                int pos2 = Integer.parseInt(m.group(2)) - 1;
                char req = m.group(3).charAt(0);
                String pw = m.group(4);
                if (pw.charAt(pos1) == req && pw.charAt(pos2) != req ||
                        pw.charAt(pos2) == req && pw.charAt(pos1) != req) {
                    ++validCount;
                }
            }
        }
        System.out.println(validCount);
    }


}