package DayTwelve.Collections;

import java.util.TreeSet;


    import java.util.*;

    public class TreeSetDemo {
        public static void main(String[] args) {
            TreeSet<Integer> ts = new TreeSet<>();

            ts.add(50);
            ts.add(10);
            ts.add(40);
            ts.add(20);

            System.out.println("TreeSet (sorted): " + ts);

            // First & Last
            System.out.println("First: " + ts.first());
            System.out.println("Last: " + ts.last());

            // Subset
            System.out.println("HeadSet(30): " + ts.headSet(30));
            System.out.println("TailSet(30): " + ts.tailSet(30));
        }
    }


