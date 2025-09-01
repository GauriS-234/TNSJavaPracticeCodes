package DayTwelve.Collections;

import java.util.Stack;


    import java.util.*;

    public class StackDemo {
        public static void main(String[] args) {
            Stack<String> stack = new Stack<>();

            // Push
            stack.push("A");
            stack.push("B");
            stack.push("C");

            System.out.println("Stack: " + stack);

            // Peek
            System.out.println("Top element: " + stack.peek());

            // Pop
            System.out.println("Popped: " + stack.pop());
            System.out.println("After pop: " + stack);

            // Empty check
            System.out.println("Is stack empty? " + stack.isEmpty());
        }
    }


