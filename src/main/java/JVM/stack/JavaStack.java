package JVM.stack;

public class JavaStack {
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        m1();
    }

    public int add(int x, int y) {
        return x + y;
    }
}
