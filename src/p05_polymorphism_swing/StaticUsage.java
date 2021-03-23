package p05_polymorphism_swing;

public class StaticUsage {

    int a;
    static int s;

    public static void main(String[] args) {
        StaticUsage.s = 10;

        StaticUsage k = new StaticUsage();
        System.out.println(k.s);

    }

}
