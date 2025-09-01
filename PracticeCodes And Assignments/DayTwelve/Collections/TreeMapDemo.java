package DayTwelve.Collections;

import java.util.TreeMap;


    import java.util.*;

    public class TreeMapDemo {
        public static void main(String[] args) {
            TreeMap<Integer, String> tm = new TreeMap<>();

            tm.put(3, "Three");
            tm.put(1, "One");
            tm.put(2, "Two");

            System.out.println("TreeMap (sorted by keys): " + tm);

            System.out.println("First key: " + tm.firstKey());
            System.out.println("Last key: " + tm.lastKey());
        }
    }


