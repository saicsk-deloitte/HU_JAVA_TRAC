 import java.util.*;
public class StringAsgmnt {
    public static boolean isShuffle(String S1, String S2, String S3)
    {

        if (S1.length() == 0 && S2.length() == 0 && S3.length() == 0) {
            return true;
        }

        if (S3.length() == 0) {
            return false;
        }
        if (S1.length() != 0 && S3.charAt(0) == S1.charAt(0)) {
            return isShuffle(S1.substring(1), S2, S3.substring(1));
        }
        if (S2.length() != 0 && S3.charAt(0) == S2.charAt(0)) {
            return isShuffle(S1, S2.substring(1), S3.substring(1));
        }
        return false;
    }
    public static void main(String[] args)
    {
        String S1;
        String S2;
        String S3;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter S1:");
        S1=s.next();
        System.out.println("Enter S2:");
        S2=s.next();
        System.out.println("Enter S3:");
        S3=s.next();
        if (isShuffle(S1, S2, S3)) {
            System.out.print("Valid Shuffle");
        }
        else {
            System.out.print("Invalid Shuffle");
        }
    }
}


