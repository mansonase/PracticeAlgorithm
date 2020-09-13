package old;

import java.util.ArrayList;
import java.util.List;


import static java.lang.System.out;

public class Hanoi {
    static class Move{
        char from,to;

        public Move(char from, char to) {
            this.from = from;
            this.to = to;
        }
    }
    List<Move> solve(int n){
        moves=new ArrayList<>();
        move(n,'A','B','C');
        return moves;
    }

    private List<Move> moves;

    private void move(int n, char a, char b, char c){
        if (n==1){
            moves.add(new Move(a,c));
        }else {
            move(n-1,a,c,b);
            move(1,a,b,c);
            move(n-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        int circleNumber=4;
        Hanoi hanoi=new Hanoi();
        for (Move move: hanoi.solve(circleNumber)){
            out.printf("from %c moving to %c%n",move.from,move.to);
        }
    }
}
