package Assignments;
import java.util.Scanner;
public class StringAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder lowerPart = new StringBuilder();
        StringBuilder upperPart = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperPart.append(ch);
            } else {
                lowerPart.append(ch);
            }
        }

        System.out.println(lowerPart.toString() + upperPart.toString());
    }
}
