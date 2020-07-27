package OOM;

public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        m();
    }

    private static void m() {
        m();
    }
}
