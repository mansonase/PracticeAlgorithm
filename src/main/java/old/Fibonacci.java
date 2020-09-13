package old;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private List<Integer> fib = new ArrayList<>();

    public Fibonacci() {
        fib.add(0);
        fib.add(1);
    }

    Integer get(int n) {
        if(n >= fib.size()) for(int i = fib.size(); i <= n; i++) {
            fib.add(fib.get(i - 1) + fib.get(i - 2));
        }
        return fib.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for(int i = 0; i < 20; i++) {
            System.out.print(fibonacci.get(i) + " ");
        }
    }
}
