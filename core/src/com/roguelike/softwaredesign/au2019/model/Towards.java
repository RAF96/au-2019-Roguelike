package com.roguelike.softwaredesign.au2019.model;

import java.util.HashMap;
import java.util.Map;

public class Towards {
    static private Map<String, Integer> deltaColumn = new HashMap<String, Integer>() {{
        put("LEFT", -1);
        put("UP", 0);
        put("RIGHT", 1);
        put("DOWN", 0);
    }};

    static private Map<String, Integer> deltaRow = new HashMap<String, Integer>() {{
        put("LEFT", 0);
        put("UP", 1);
        put("RIGHT", 0);
        put("DOWN", -1);
    }};


    public static Integer getDeltaRow(String towards) {
        return deltaRow.get(towards);
    }

    public static Integer getDeltaColumn(String towards) {
        return deltaColumn.get(towards);
    }

}
