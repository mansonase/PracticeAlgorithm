package old;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Knight {

    public static int count=0;

    public static class Step{
        final int x,y;

        public Step(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int[][] travel(Step start){
        int[][] board=new int[8][8];

        board[start.x][start.y]=1;
        Step current=start;

        for (int s=2;s<65;s++){
            List<Step> possibleSteps=possible(board,current);

            if (possibleSteps.isEmpty()){
                break;
            }

            if (possibleSteps.size()==1){
                current=possibleSteps.get(0);
            }else {
                current=hard(board,possibleSteps);
            }

            board[current.x][current.y]=s;
        }

        return board;
    }
    public static List<Step> possible(int[][] board, Step step){
        int[][] dirs={{-2,1},{-1,2},{1,2},{2,1},
                      {2,-1},{1,-2},{-1,-2},{-2,-1}};
        List<Step> steps=new ArrayList<>();
        for (int[] dir:dirs){
            Step s=new Step(step.x+dir[0],step.y+dir[1]);
            if (isVisitable(board,s)){
                steps.add(s);
                count++;
            }
        }
        return steps;
    }

    public static boolean isVisitable(int[][] board, Step step){
        return step.x>-1&&step.x<8&&
                step.y>-1&&step.y<8&&
                board[step.x][step.y]==0;
    }
    public static Step hard(int[][] board, List<Step> steps){
        int minIndex=0;
        List<Step> minPossibleSteps=possible(board,steps.get(0));

        for (int i=1;i<steps.size();i++){
            List<Step> possibleSteps=possible(board,steps.get(i));
            if (possibleSteps.size()<minPossibleSteps.size()){
                minIndex=i;
                minPossibleSteps=possibleSteps;
                //count++;
            }
        }
        return steps.get(minIndex);
    }

    public static void main(String[] args) {

        long beforeTime=System.currentTimeMillis();

        for (int[] row: travel(new Step(4,4))){
            for (int step: row){
                out.printf("%3d", step);
            }
            out.println();
        }
        out.print("time needs "+(System.currentTimeMillis()-beforeTime));
        out.println();
        out.print("total calculate count is "+count);
    }
}
