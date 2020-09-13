package old;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class StringMatcher implements Iterable<String> {
    private String str;
    private String key;
    private int[] skip = new int[256];

    public StringMatcher(String str, String key) {
        this.str = str;
        this.key = key;
        Arrays.fill(skip, key.length());
        for(int k = 0; k < key.length() - 1; k++) {
            skip[key.charAt(k)] = key.length() - k - 1;
            out.println("nononow "+key.charAt(k));
        }
    }

    public Iterator<String> iterator() { return new Itr(); }

    private class Itr implements Iterator<String> {
        private int index;

        { index = indexOf(key.length() - 1, str, key); }

        private int indexOf(int from, String str, String key) {
            int tp = from;
            while(tp < str.length() &&
                    ! str.substring(tp - key.length() + 1, tp + 1)
                            .equals(key)) {
                tp += skip[str.charAt(tp)];
            }
            return tp - key.length() + 1;
        }

        public boolean hasNext() {
            return index < str.length() - 1;
        }

        public String next() {
            String sub = str.substring(index);
            index = indexOf(index + key.length() + 1, str, key);
            return sub;
        }

        public void remove() { throw new RuntimeException("Not supported"); }
    }

    public static void main(String[] args) {


        String str = "hexxo i'm working on computer com con";

        String key = "xxo";



/*
        Scanner scanner = new Scanner(in);

        out.print("please enter strings: ");
        String str = scanner.nextLine();
        out.print("enter key words: ");
        String key = scanner.nextLine();

 */


        for(String s : new StringMatcher(str, key)) {
            out.println(s);
        }
    }
}
