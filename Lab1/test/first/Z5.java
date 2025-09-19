package test.first;
public class Z5 {
    public static void main(String[] args) {
        int number = 5;
        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }

        System.out.println("Факториал числа " + number + " = " + factorial);
    }
}
