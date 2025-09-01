package DayTwelve.Collections;

import java.util.LinkedHashSet;


    import java.util.*;

    public class LinkedHashSetDemo {
        public static void main(String[] args) {
            LinkedHashSet<String> set = new LinkedHashSet<>();

            set.add("One");
            set.add("Two");
            set.add("Three");
            set.add("One"); // duplicate ignored

            System.out.println("LinkedHashSet (preserves order): " + set);

            set.remove("Two");
            System.out.println("After removal: " + set);
        }
    }


