package old;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

class Queen{
    final int x,y;

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)",x,y);
    }
}
public class Queens {

    public static List<List<Queen>> queens(int n){
        return placeQueens(n,n);
    }
    public static List<List<Queen>> placeQueens(int n, int k){
        List<List<Queen>> queensList=new ArrayList<>();
        if (k==0){
            queensList.add(new ArrayList<Queen>());
            out.println("size of queenslist is : "+queensList.size());
        }else {
            for (List<Queen> queens: placeQueens(n,k-1)){
                for (int column=1;column<=n;column++){
                    Queen queen=new Queen(k,column);
                    if (isSafe(queen,queens)){
                        List<Queen> qs=new ArrayList<>();
                        qs.addAll(queens);
                        qs.add(queen);
                        queensList.add(qs);
                    }
                }
            }
        }
        return queensList;
    }

    public static boolean isSafe(Queen queen, List<Queen> queens){
        for (Queen q:queens){
            if (inCheck(queen,q)){
                return false;
            }
        }
        return true;
    }

    public static boolean inCheck(Queen q1, Queen q2){
        return q1.x==q2.x||
                q1.y==q2.y||
                Math.abs(q1.x-q2.x)==Math.abs(q1.y-q2.y);
    }

    public static void main(String[] args) {
        int count=0;
        for (List<Queen> queens: queens(8)){
            for (Queen queen: queens){
                out.print(queen);
            }
            count++;
            out.print(queens.size());
            out.println();
            if (count==1){
                break;
            }
        }
        out.println(count);


        List<List<Queen>> allQueen=new ArrayList<>();
        if (allQueen.isEmpty()){
            out.println("size of all queen is : "+allQueen.size());
        }
    }
}
