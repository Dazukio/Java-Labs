package test.first;
public class Z2 {
    public static void main(String[] args) {

        for (int i = 1; i <= 500; i++) {

            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println(i + "fizzbuzz");
            }

            else if (i % 5 == 0) {
                System.out.println(i + "fizz");
            }

            else if (i % 7 == 0) {
                System.out.println(i + "buzz");
            }

        }
    }
}
