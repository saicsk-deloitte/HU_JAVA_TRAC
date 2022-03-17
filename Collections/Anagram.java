package Collections;
import java.util.Arrays;
import java.util.Scanner;
    class Anagram{
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter String1:");
            String str1 = input.nextLine();
            System.out.print("Enter String2: ");
            String str2 = input.nextLine();
            if(str1.length() == str2.length()) {
                char[] charArray1 = str1.toCharArray();
                char[] charArray2 = str2.toCharArray();
                Arrays.sort(charArray1);
                Arrays.sort(charArray2);
                boolean result = Arrays.equals(charArray1, charArray2);
                if(result) {
                    System.out.println("Anagram");
                }
                else {
                    System.out.println("Not Anagram");
                }
            }
            else {
                System.out.println("Not Anagram");
            }
        }
    }
}
