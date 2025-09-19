package test.first;
public class Z4 {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("Последовательность чисел Фибоначчи:");

        int prev = 1;
        int current = 1;

        System.out.print(prev + " " + current + " ");

        for (int i = 2; i < n; i++) {
            int next = prev + current;
            System.out.print(next + " ");
            prev = current;
            current = next;
        }
    }
}
