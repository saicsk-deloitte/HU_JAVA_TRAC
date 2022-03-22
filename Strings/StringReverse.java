package Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StringReverse {
    public static void main(String[] args)
    {
        ArrayList<String> string=new ArrayList<>(Arrays.asList("Hashedin","by","deloitte","2022"));
        System.out.println("Reversed order of a given list:");
        Collections.reverse(string);
        System.out.println(string);

    }
}