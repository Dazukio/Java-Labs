package test.first;
public class Z3 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы не переданы");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            String word = args[i];
            for (int j = word.length() - 1; j >= 0; j--) {
                System.out.print(word.charAt(j));
            }
        }
    }
}
