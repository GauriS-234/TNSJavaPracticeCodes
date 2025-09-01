package DayTwelve.Collections;

import java.util.LinkedList;


    import java.util.*;

    public class LinkedListDemo {
        public static void main(String[] args) {
            LinkedList<Integer> numbers = new LinkedList<>();

            // Add elements
            numbers.add(10);
            numbers.add(20);
            numbers.addFirst(5);
            numbers.addLast(30);

            System.out.println("LinkedList: " + numbers);

            // Get & set
            System.out.println("First: " + numbers.getFirst());
            System.out.println("Last: " + numbers.getLast());

            // Remove
            numbers.removeFirst();
            numbers.removeLast();
            System.out.println("After removals: " + numbers);

            // Iteration
            System.out.println("Iteration:");
            for (int num : numbers) {
                System.out.println(num);
            }
        }
    }


