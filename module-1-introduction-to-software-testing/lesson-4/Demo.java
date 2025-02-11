import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter side 1: ");
    int side1 = scanner.nextInt();
    System.out.println("Enter side 2: ");
    int side2 = scanner.nextInt();
    System.out.println("Enter side 3: ");
    int side3 = scanner.nextInt();

    if (isTriangle(side1, side2, side3)) {
      System.out.println("It is a triangle.");
    } else {
      System.out.println("It is not a triangle.");
    }

    scanner.close();
  }

  public static boolean isTriangle(double a, double b, double c) {
    return a + b > c && a + c > b && b + c > a;
  }
}
