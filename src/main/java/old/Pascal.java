package old;


import java.util.ArrayList;
import java.util.List;

public class Pascal {

    private List<List<Integer>> rows=new ArrayList<>();

    public Pascal(int height) {
        for (int r=0;r<height;r++){
            rows.add(createRow(r));
        }
    }

    private List<Integer> createRow(int r){
        List<Integer> row=new ArrayList<>();
        row.add(1);
        for (int n=1;n<=r;n++){
            row.add(row.get(n-1)*(r-n+1)/n);
        }
        return row;
    }

    int combi(int r,int n){
        return rows.get(r).get(n);
    }

    public static void main(String[] args) {
        final int HEIGHT=12;
        Pascal p=new Pascal(HEIGHT);

        for (int r=0;r<HEIGHT;r++){
            System.out.printf(String.format("%%%ds",(HEIGHT-r)*3),"");
            for (int n=0;n<=r;n++){
                System.out.printf("%6d",p.combi(r,n));
            }
            System.out.println();
        }
    }


}
