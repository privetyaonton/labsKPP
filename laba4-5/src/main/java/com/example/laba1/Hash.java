package com.example.laba1;
import java.util.HashMap;

public class Hash {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public boolean isContain(Integer key) {
        return map.containsKey(key);
    }
    public void addToMap(Integer key, Integer result) {
        map.put(key, result);
    }
    public int getParameters(Integer key) {
        return map.get(key);
    }
}
