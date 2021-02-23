package p01_intro;

public class Variables {
    public static void main(String[] args) {
        // Primitive data types
        byte age = 45;                  // 8-bit integer
        short capacity = 120;           // 16-bit integer
        int orders = 56098;             // 32-bit integer
        long infected = 1908765;        // 64-bit integer

        float salary = 1087.45f;        // 32-bit floating-point number
        double budget = 5901874.12;     // 64-bit floating-point number

        char letter = 'a';              // 16-bit Unicode character

        boolean graduated = false;      // True or False value

        // Not a primitive data type but looks like
        String name = "James";          // String literal

        // Arrays
        int values[];
        int monthDays[] = new int[12];
        monthDays[0] = 31;      // Array index starts at ZERO (0)
        monthDays[1] = 28;
        // etc
        int salesPerMonth[] = {23, 12, 45, 12, 14, 9, 23, 11, 14, 10, 19, 8};
        // Multi-dimensional
        int chessBoard[][] = new int[8][8];

        // Type inference
        var w = 10.4;       // w becomes double

    }
}
