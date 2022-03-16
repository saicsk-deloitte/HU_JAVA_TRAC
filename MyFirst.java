import java.lang.*;
        import java.util.Scanner;

public class Area {
    double area(double r) {
        return Math.PI * r * r;
    }
    double area(float l) {
        return l * l;
    }
    double area(double l, double b) {
        return l * b;
    }
    double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));

    }
    public static void main(String[] args) {
        Area a1 = new Area();
        int choice;
        Scanner s = new Scanner(System.in);
        System.out.print(" 1.Circle \n 2.Square \n 3.Rectangle\n 4.Triangle \n\n Enter your choice:");
        choice=s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter radius of Circle");
                double r = s.nextDouble();
                System.out.println(a1.area(r));
                break;
            case 2:
                System.out.println("Enter side of the square");
                float side = s.nextFloat();
                System.out.println(a1.area(side));
                break;
            case 3:
                System.out.println("Enter length and breadth of Rectangle");
                double l = s.nextDouble();
                double b = s.nextDouble();
                System.out.println(a1.area(l, b));
                break;
            case 4:
                System.out.println("Enter three sides of triangle ");
                double x = s.nextDouble();
                double y = s.nextDouble();
                double z = s.nextDouble();
                System.out.println(a1.area(x, y, z));
                break;
            default:
                System.out.println("Entered value is invalid");

        }
    }
}

