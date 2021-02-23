package p01_intro;

public class Operators {
    public static void main(String[] args) {
        int x = 180;
        int y = 47;

        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + (x / y));  // Division. NOTE: Integer division gives integer result
        System.out.println("x % y = " + (x % y));  // Modulus, remainder of the division

        // Assignment
        int a = 10;
        a += 5;         // Add 5 to the current value of a. Now a is 15
        a -= 3;         // Now a is 12
        a *= 2;         // Now a is 24
        a /= 3;         // Now a is 8
        a %= 5;         // Now a is 3
        System.out.println("Value of a after assignments: " + a);

        // Increment and decrement
        int k = 5;
        int m;

        m = k++;    // Post-increment. k (5) is assigned to m and the k increased by 1
        System.out.println("Post-increment, m = " + m);     // m = 5
        System.out.println("Post-increment, k = " + k);     // k = 6
        m = ++k;    // Pre-increment. k was (6) increased by 1 and then assigned to m
        System.out.println("Pre-increment, m = " + m);     // m = 7
        System.out.println("Pre-increment, k = " + k);     // k = 7

        // Relational operators
        int c = 100;
        int d = 30;
        int e = 100;

        System.out.println(c == d); // Equal (False)
        System.out.println(c != d); // Not equal (True)
        System.out.println(c >= e); // Greater than or equal (True)
        System.out.println(c > d); // Greater than (True)
        System.out.println(c < d); // Less than (False)
        System.out.println(c <= e); // Less than or equal (True)

        System.out.println(c > d && c > e); // Logical AND (False)
        System.out.println(c > d || c > e); // Logical OR (True)
    }
}
