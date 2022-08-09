package common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机UA生成
 * @author Hoyoung
 */
public class UAGenerator {
    static private List<String> uaList = new ArrayList<>();

    static {
        uaList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
        uaList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
        uaList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.81 Safari/537.36 Edg/104.0.1293.47");
    }

    static List<String> uaList(){
        return uaList;
    }

    static String randomOneUA(){
        return uaList().get(new Random().nextInt(uaList.size()));
    }

    private UAGenerator() {
    }
}
