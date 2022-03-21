public class ExceptionExample {
    public void checkForException(int a,int b){
        try {
            int remainder = a / b;
            System.out.println("Remainder is:"+remainder);

        }
        catch(ArithmeticException ae){
            System.out.println("Found an Arithmetic Exception Divide by zero");

        }
        finally{
            System.out.println("Thank You");
        }
    }
    public static void main(String[] args){
        ExceptionExample e1=new ExceptionExample();
        e1.checkForException(5,0);
        e1.checkForException(0,0);
        e1.checkForException(10,5);
        e1.checkForException(2,2);

    }
}


