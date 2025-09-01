package DayTwelve.Collections;

import java.util.PriorityQueue;


    import java.util.*;

    public class QueueDemo {
        public static void main(String[] args) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            pq.add(30);
            pq.add(10);
            pq.add(20);

            System.out.println("PriorityQueue: " + pq);
            System.out.println("Peek: " + pq.peek());

            // Poll removes smallest
            System.out.println("Poll: " + pq.poll());
            System.out.println("After poll: " + pq);
        }
    }


