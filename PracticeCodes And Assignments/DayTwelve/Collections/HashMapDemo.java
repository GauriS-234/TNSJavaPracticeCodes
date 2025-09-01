package DayTwelve.Collections;

import java.util.HashMap;
import java.util.Map;


    import java.util.*;

    public class HashMapDemo {
        public static void main(String[] args) {
            HashMap<Integer, String> map = new HashMap<>();

            // Put values
            map.put(1, "One");
            map.put(2, "Two");
            map.put(3, "Three");

            System.out.println("HashMap: " + map);

            // Get
            System.out.println("Value for key 2: " + map.get(2));

            // Remove
            map.remove(3);
            System.out.println("After removal: " + map);

            // Iteration
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
            }
        }
    }


