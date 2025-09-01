package DayTwelve.Collections;

import java.util.HashSet;


    import java.util.*;

    public class HashSetDemo {
        public static void main(String[] args) {
            HashSet<String> set = new HashSet<>();

            set.add("Red");
            set.add("Green");
            set.add("Blue");
            set.add("Red"); // duplicate ignored

            System.out.println("HashSet: " + set);

            // Contains
            System.out.println("Contains Green? " + set.contains("Green"));

            // Remove
            set.remove("Blue");
            System.out.println("After removal: " + set);

            // Iteration
            for (String color : set) {
                System.out.println(color);
            }
        }
    }


