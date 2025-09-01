package DayTwo.loopingStatements;

public class NestedforLoopDemo {


        public static void main(String[] args) {

            int beg= 10;
            int end = 11;

            for(int i=beg; i<=end; i++)
            {
                for(int j=1; j<=10; j++)
                {
                    System.out.println(i*j);
                }
                System.out.println();

            }

        }

    }
