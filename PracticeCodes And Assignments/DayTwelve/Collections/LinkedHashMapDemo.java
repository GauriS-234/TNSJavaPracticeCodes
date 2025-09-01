package DayTwelve.Collections;

import java.util.LinkedHashMap;

    import java.util.*;

    public class LinkedHashMapDemo {
        public static void main(String[] args) {
            LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();

            lhm.put(1, "A");
            lhm.put(2, "B");
            lhm.put(3, "C");

            System.out.println("LinkedHashMap (order preserved): " + lhm);
        }
    }


