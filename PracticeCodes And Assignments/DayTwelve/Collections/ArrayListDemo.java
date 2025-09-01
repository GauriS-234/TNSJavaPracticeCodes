package DayTwelve.Collections;

import java.util.ArrayList;
import java.util.*;


    public class ArrayListDemo {
        public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<>();

            // Add elements
            list.add("Apple");
            list.add("Banana");
            list.add("Mango");
            list.add("Banana"); // allows duplicates

            System.out.println("ArrayList: " + list);

            // Get element
            System.out.println("Element at index 1: " + list.get(1));

            // Update element
            list.set(2, "Orange");
            System.out.println("After update: " + list);

            // Remove element
            list.remove("Banana"); // removes first occurrence
            System.out.println("After removal: " + list);

            // Check contains
            System.out.println("Contains Apple? " + list.contains("Apple"));

            // Iteration
            System.out.println("Iteration:");
            for (String fruit : list) {
                System.out.println(fruit);
            }
        }
    }


