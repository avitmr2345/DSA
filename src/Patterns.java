public class Patterns {
    public static void main(String[] args) {
        pattern7(8);
        pattern8(8);
        pattern10(8);
        pattern11(8);
        pattern12(6);
        pattern14(5);
        pattern17(6);
        pattern18(5);
        pattern19(5);
        pattern20(6);
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

    private static void pattern12(int n) {
        int spaces = 2 * n - 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = spaces; k > 0; k--) {
                System.out.print(" ");
            }
            for (int l = i; l >= 1; l--) {
                System.out.print(l);
            }
            spaces -= 2;
            System.out.println();
        }
    }

    private static void pattern14(int n) {
        for (int i = 1; i <= n; i++) {
            char c = 'A';
            for (int j = 0; j < i; j++) {
                System.out.print((char) (c + j));
            }
            System.out.println();
        }
    }

    private static void pattern17(int n) {
        int spaces = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            char c = 'A';
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print(c);
                if (k < i) {
                    c++;
                } else {
                    c--;
                }
            }
            for (int l = 0; l < spaces; l++) {
                System.out.print(" ");
            }
            spaces--;
            System.out.println();
        }
    }

    private static void pattern18(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = (char) (('A' + n - 1) - i); ch <= (char) ('A' + n - 1); ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static void pattern19(int n) {
        int spaces = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j >= 1; j--) {
                System.out.print("*");
            }
            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }
            spaces += 2;
            for (int l = n - i; l >= 1; l--) {
                System.out.print("*");
            }
            System.out.println();
        }

        spaces = 2 * n - 2;
        for (int x = 1; x <= n; x++) {
            for (int j = 1; j <= x; j++) {
                System.out.print("*");
            }
            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }
            spaces -= 2;
            for (int l = 1; l <= x; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern20(int n) {
        int spaces = 2 * n - 2;
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            if (i < n) {
                spaces -= 2;
            } else
                spaces += 2;

            for (int l = 1; l <= stars; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}