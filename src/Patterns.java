public class Patterns {
    public static void main(String[] args) {
        pattern7(8);
        pattern8(8);
        pattern10(8);
        pattern11(8);
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

    private static void pattern11(int n) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                num1 = 0;
                num2 = 1;
            } else {
                num1 = 1;
                num2 = 0;
            }
            for (int j = 1; j <= i; j++) {
                if (j % 2 == 0) {
                    System.out.print(num2);
                } else {
                    System.out.print(num1);
                }
            }
            System.out.println();
        }
    }
}