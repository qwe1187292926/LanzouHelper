package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UAGenerator {
    static private List<String> uaList = new ArrayList<>();

    static {
        uaList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
    }

    static List<String> uaList(){
        return uaList;
    }

    static String randomOneUA(){
        return uaList().get(new Random().nextInt(uaList.size()));
    }
}
