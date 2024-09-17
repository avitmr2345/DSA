public class Patterns {
    public static void main(String[] args) {
        pattern7(8);
        pattern8(8);
        pattern10(8);
    }

    private static void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (j <= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 1; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern8(int n) {
        int counter = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 1; k < counter; k++) {
                System.out.print("*");
            }
            counter--;
            System.out.println();
        }
    }

    private static void pattern10(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int star = i;
            if (i > n)
                star = 2 * n - i;
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}