package DayEleven.String;


    public class StringDemo {
        public static void main(String[] args) {
            // 1. Creating strings
            String s1 = "Hello";
            String s2 = "World";
            String s3 = new String("Hello");

            // 2. String comparison
            System.out.println("s1 equals s2: " + s1.equals(s2));     // false
            System.out.println("s1 equals s3: " + s1.equals(s3));     // true
            System.out.println("s1 == s3: " + (s1 == s3));            // false (different objects)
            System.out.println("s1 equalsIgnoreCase 'HELLO': " + s1.equalsIgnoreCase("HELLO"));

            // 3. Length of string
            System.out.println("Length of s1: " + s1.length());

            // 4. Concatenation
            String combined = s1 + " " + s2;
            System.out.println("Concatenated: " + combined);
            System.out.println("Using concat(): " + s1.concat(s2));

            // 5. Character at index
            System.out.println("Character at index 1 in s1: " + s1.charAt(1));

            // 6. Substring
            System.out.println("Substring (1,4) in s1: " + s1.substring(1, 4));

            // 7. Contains & indexOf
            System.out.println("s1 contains 'll': " + s1.contains("ll"));
            System.out.println("Index of 'l' in s1: " + s1.indexOf('l'));
            System.out.println("Last index of 'l' in s1: " + s1.lastIndexOf('l'));

            // 8. Replace
            System.out.println("Replace 'l' with 'x' in s1: " + s1.replace('l', 'x'));

            // 9. Case conversion
            System.out.println("Uppercase s1: " + s1.toUpperCase());
            System.out.println("Lowercase s2: " + s2.toLowerCase());

            // 10. Trim (remove leading/trailing spaces)
            String spaced = "   Java Strings   ";
            System.out.println("Before trim: '" + spaced + "'");
            System.out.println("After trim: '" + spaced.trim() + "'");

            // 11. Split
            String sentence = "Java is fun to learn";
            String[] words = sentence.split(" ");
            System.out.println("Splitting sentence:");
            for (String word : words) {
                System.out.println(word);
            }

            // 12. StartsWith & EndsWith
            System.out.println("s1 starts with 'He': " + s1.startsWith("He"));
            System.out.println("s2 ends with 'ld': " + s2.endsWith("ld"));

            // 13. ValueOf (convert primitives to string)
            int num = 100;
            String strNum = String.valueOf(num);
            System.out.println("String value of int 100: " + strNum);

            // 14. isEmpty & isBlank
            String empty = "";
            String blank = "   ";
            System.out.println("empty isEmpty(): " + empty.isEmpty());
            System.out.println("blank isBlank(): " + blank.isBlank());

            // 15. Join
            String joined = String.join("-", "Java", "Python", "C++");
            System.out.println("Joined string: " + joined);

            // 16. StringBuilder for mutable strings
            StringBuilder sb = new StringBuilder("Hello");
            sb.append(" World");
            sb.insert(5, ",");
            sb.replace(0, 5, "Hi");
            sb.delete(2, 3);
            sb.reverse();
            System.out.println("StringBuilder final result: " + sb);
        }
    }

