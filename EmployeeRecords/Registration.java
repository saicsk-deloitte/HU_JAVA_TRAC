package EmployeeRecords;
import java.io.*;
import java.util.Scanner;
class UserDB{
    void addUserData(String UserName) {
        try
        {
        Scanner s = new Scanner(System.in);
        FileWriter f1 = new FileWriter("C:\\Users\\Chamkumar\\Desktop\\userDB.txt", true);
        System.out.print("Enter UserID:");
        String UserID = s.next();
        System.out.print("Enter Name:");
        String Name = s.next();
        System.out.print("Enter Age:");
        int Age = s.nextInt();
            while(Age<18 || Age>90){
                System.out.println("Age must be greater than 18 and less than 90");
                System.out.println("Enter Valid Age:");
                Age=s.nextInt();
            }
        System.out.print("Enter Company Name:");
        String CompanyName = s.next();
        System.out.print("Enter Designation:");
        String Designation = s.next();
        System.out.print("Enter Salary:");
        int Salary = s.nextInt();
        System.out.print("Enter Address:");
        String Address = s.next();
        System.out.print("Enter Mobile no:");
        String Mobileno = s.next();
        while(Mobileno.length()!=10){
            System.out.println("Mobile number should contain 10 digits");
            System.out.println("Re-enter 10 digits Mobile number:");
            Mobileno=s.next();
        }
        String data = UserName+" "+UserID +" "+ Name + " " + Integer.toString(Age) +" "+ CompanyName +" "+ Designation+ " " + Integer.toString(Salary)+" " + Address +" "+ Mobileno + '\n';
        f1.write(data);
        f1.close();
            System.out.println("\n USER DETAILS ADDED SUCCESSFULLY");
    }
         catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }
    void listUserData(String UserName){
        try {
            File f = new File("C:\\Users\\Chamkumar\\Desktop\\userDB.txt");
            Scanner s=new Scanner(f);
            while(s.hasNextLine()){
                String s1=s.nextLine();
                String[] Details=s1.split(" ");
                if(Details[0].equals(UserName)){
                    System.out.println("UserId:"+Details[1]);
                    System.out.println("Name:"+Details[2]);
                    System.out.println("Age:"+Details[3]);
                    System.out.println("Company Name:"+Details[4]);
                    System.out.println("Designation:"+Details[5]);
                    System.out.println("Salary:"+Details[6]);
                    System.out.println("Address:"+Details[7]);
                    System.out.println("Mobile no:"+Details[8]);

                }
            }
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }

        }
       void updateUserData(String UserName){
try{
    File f = new File("C:\\Users\\Chamkumar\\Desktop\\userDB.txt");
    Scanner s=new Scanner(f);
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the choice of the field to be changed from below:");
    System.out.print(" 1.Name\n 2.Age\n 3.CompanyName\n  4.Designation\n 5.Salary\n 6.Address\n 7.Mobile no\n ");
    int choice=sc.nextInt();
    System.out.print("\n\nPlease enter the updated value:");
    String v1=sc.next();
    while(s.hasNextLine()){
        String s1=s.nextLine();
        System.out.println(s1);
        String[] Details=s1.split(" ");
        if(Details[0].equals(UserName)){
            FileWriter writer=new FileWriter("C:\\Users\\Chamkumar\\Desktop\\userDB.txt",true);
                writer.write(s1.replaceAll(Details[choice+1],v1));
                writer.close();
            break;
    }

       }}
catch(IOException e) {
    System.out.println("exception occurred" + e);
}}

}
public class Registration {
    private void register() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name: ");
        String Uname = sc.nextLine();
        System.out.println(Uname);
        System.out.println("Enter Password: ");
        String Pass = sc.nextLine();
        System.out.println(Pass);
        System.out.println("Confirm Password: ");
        String ConPass = sc.nextLine();
        System.out.println(ConPass);
        Uname = Uname.trim();
        Pass = Pass.trim();
        ConPass = ConPass.trim();
        String x = Uname + " " + Pass;
        int test=0;
        try {

           ValidPassword.isValid(Pass);
            System.out.println("Valid Password");
        }
        catch (InvalidPasswordException e) {
            System.out.print(e.getMessage());
            System.out.println(e.printMessage());
            test=1;
        }
        if (Pass.equals(ConPass) && test==0) {
            File f = new File("C:\\Users\\Chamkumar\\Desktop\\Registration1.txt");
            Scanner content = new Scanner(f);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if (data.equals(x)) {
                    System.out.println("Already Registered");
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                try {
                    FileWriter  out = new FileWriter("C:\\Users\\Chamkumar\\Desktop\\Registration1.txt", true);
                    out.write(Uname + " " + Pass + "\n");
                    out.close();
                } catch (IOException e) {
                    System.out.println("exception occurred" + e);
                }
                System.out.println("Successfully Registered");
                System.out.println("Please login");
                this.login();
            }
            content.close();
        } else {
            System.out.println("Recheck");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");
            System.out.println("Enter your Choice");
            int choice = sc.nextInt();
            if (choice == 1) {
                this.register();
            } else if (choice == 2) {
                this.login();
            } else {
                System.out.println("Choose Proper Option");
            }
        }

    }
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name: ");
        String Uname = sc.nextLine();
        System.out.println(Uname);
        System.out.println("Enter Password: ");
        String Pass = sc.nextLine();
        System.out.println(Pass);
        Uname = Uname.trim();
        Pass = Pass.trim();
        String x = Uname + " " + Pass;
        try {
            File f = new File("C:\\Users\\Chamkumar\\Desktop\\Registration1.txt");
            Scanner content = new Scanner(f);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if (data.equals(x)) {
                    flag = 1;
                    System.out.println("Login Successful");
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("Login Failed");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");
                System.out.println("Enter your Choice");
                int choice = sc.nextInt();
                if (choice == 1) {
                    this.register();
                } else if (choice == 2) {
                    this.login();
                } else {
                    System.out.println("Choose Proper Option");
                }
            }
            content.close();
            System.out.println("\n\n*****Welcome to the Application*****\n\n");
            while(true) {
                System.out.println("\n\n*******Welcome to the UserDB********\n\n  1.Add UserData\n  2.List User Data\n  3.Update User Data\n   4. Delete User Data\n    5. Exit\n   ");
                System.out.print("Enter your choice");
                int Choice = sc.nextInt();
                UserDB d = new UserDB();
                switch(Choice) {
                    case 1:
                        d.addUserData(Uname);
                        break;
                    case 2:
                        d.listUserData(Uname);
                        break;
                    case 3:
                        d.updateUserData(Uname);
                        break;
                    //case 4:
                        //d.deleteUserData(Uname);
                    case 5:
                        System.exit(0);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File obj = new File("C:\\Users\\Chamkumar\\Desktop\\Registration1.txt");
            if (obj.createNewFile()) {
                System.out.println("File is created");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int choice;
        Scanner sc = new Scanner(System.in);
        Registration user = new Registration();
        System.out.println("1. Registration. ");
        System.out.println("2. Login. ");
        System.out.println("Enter your Choice");
        choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {

            user.register();
        } else if (choice == 2) {

            user.login();
        } else {
            System.out.println("Choose Proper Option");
        }
    }
}
class InvalidPasswordException extends Exception {
    int passwordConditionViolated = 0;
    public InvalidPasswordException(int conditionViolated)
    {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }
    public String printMessage()
    {
        switch (passwordConditionViolated) {
            case 1:
                return ("Password length should be"
                        + " between 5 to 10 characters");
            case 2:
                return ("Password should not"
                        + " contain any space");
            case 3:
                return ("Password should contain"
                        + " at least one digit(0-9)");
            case 4:
                return ("Password should contain at "
                        + "least one special character");
            case 5:
                return ("Password should contain at"
                        + " least one uppercase letter(A-Z)");
            case 6:
                return ("Password should contain at"
                        + " least one lowercase letter(a-z)");
        }

        return ("");
    }
}
class ValidPassword {
     public static void isValid(String password)
             throws InvalidPasswordException {
         if (((password.length() < 5)
                 || (password.length() > 10))) {
             throw new InvalidPasswordException(1);
         }

         if (password.contains(" ")) {
             throw new InvalidPasswordException(2);
         }
         if (true) {
             int count = 0;
             for (int i = 0; i <= 9; i++) {

                 String str1 = Integer.toString(i);

                 if (password.contains(str1)) {
                     count = 1;
                 }
             }
             if (count == 0) {
                 throw new InvalidPasswordException(3);
             }
         }
         if (!(password.contains("@") || password.contains("#")
                 || password.contains("!") || password.contains("*")
                 || password.contains("&") || password.contains("%"))) {
             throw new InvalidPasswordException(4);
         }
         if (true) {
             int count = 0;
             for (int i = 65; i <= 90; i++) {
                 char c = (char) i;
                 String str1 = Character.toString(c);
                 if (password.contains(str1)) {
                     count = 1;
                 }
             }
             if (count == 0) {
                 throw new InvalidPasswordException(5);
             }
         }
         if (true) {
             int count = 0;
             for (int i = 90; i <= 122; i++) {
                 char c = (char) i;
                 String str1 = Character.toString(c);
                 if (password.contains(str1)) {
                     count = 1;
                 }
             }
             if (count == 0) {
                 throw new InvalidPasswordException(6);
             }
         }
     }
 }