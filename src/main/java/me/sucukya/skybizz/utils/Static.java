package me.sucukya.skybizz.utils;

import java.util.HashMap;
import java.util.Map;

public class Static {

    public static Map<String,Integer> colorMatcher = new HashMap<>();

    public static void initialize() {
        colorMatcher.put("0",0);
        colorMatcher.put("1",170);
        colorMatcher.put("2",43520);
        colorMatcher.put("3",43690);
        colorMatcher.put("4",11141120);
        colorMatcher.put("5",11141290);
        colorMatcher.put("6",16755200);
        colorMatcher.put("7",11184810);
        colorMatcher.put("8",5592405);
        colorMatcher.put("9",5592575);
        colorMatcher.put("a",5635925);
        colorMatcher.put("b",5636095);
        colorMatcher.put("c",16733525);
        colorMatcher.put("d",16733695);
        colorMatcher.put("e",16777045);
        colorMatcher.put("f",16777215);
    }
}
