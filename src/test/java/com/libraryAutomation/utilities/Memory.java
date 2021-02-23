package com.libraryAutomation.utilities;

import java.util.Hashtable;
import java.util.Map;

public class Memory {


    private Memory() {

    }


    private static Map<String, String> map;

   private static void initMemory() {
        map = new Hashtable<>();
    }


    public static void saveValue(String key, String value) {
        initMemory();
        map.put(key, value);
    }

    public synchronized static String retrieveValue(String key) {
        return map.get(key);
    }
    public synchronized static void refresh(){
        map.clear();
    }
}
