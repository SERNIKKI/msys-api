package com.nikki.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomUtil {
    /**
     * 字符源，可以剔除O、L、0和1，避免0和1与O和L混淆，这里没有剔除<br/>
     * 可以根据需要加入小写英文字母和特殊字符等
     */
    private static final String[] GENERATE_SOURCE = new String[]{"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g","h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"};
    private static final int STR_LEN = GENERATE_SOURCE.length;

    private static final String[] NUMBER = new String[]{"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9"};
    private static final int NUM_LEN = NUMBER.length;

    public int getNum(){
        List<String> list = Arrays.asList(NUMBER);
        Collections.shuffle(list);
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < NUM_LEN; i++){
            randomStr.append(list.get(i));
        }
        String str = randomStr.substring(3,9);
        return Integer.parseInt(str);
    }

    public  String generateByShuffle() {
        List<String> list = Arrays.asList(GENERATE_SOURCE);
        //打乱元素顺序，增加反推难度
        Collections.shuffle(list);
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < STR_LEN; i++){
            randomStr.append(list.get(i));
        }
        return randomStr.substring(4,32);
    }

}
