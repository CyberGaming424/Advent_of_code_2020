package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static ArrayList<String> lines(String path){
        try{
            return new ArrayList<>(Arrays.asList(Files.lines(Path.of(path)).toArray(String[]::new)));
        }catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
