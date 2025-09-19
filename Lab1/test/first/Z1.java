package test.first;

/**
 * zxcursed - mana break
 *
 * [▶] [=========-----] 00:21 / 01:33
 *
 */

public class Z1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы не переданы");
            return;
        }

        System.out.println("Переданные аргументы:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент " + (i + 1) + ": " + args[i]);
        }
    }
}
