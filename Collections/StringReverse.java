package Collections;
import java.util.*;

public class StringReverse {
    public static void main (String []args){
        List<String> l1= new  ArrayList<String>();
        Scanner s= new Scanner(System.in);
        System.out.println("Enter size of the list");
        int n=s.nextInt();
        System.out.println("Enter the elements of List");
        for(int i=0;i<n;i++)
        {
            String s1=s.next();
            l1.add(s1);
        }
        for(int j=n-1;j>=0;j--);
        System.out.print(l1[1]+" ");

    }

}
