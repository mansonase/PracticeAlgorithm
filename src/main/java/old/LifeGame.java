package old;

import java.util.Arrays;

import static java.lang.System.out;

class Cell{
    final int i,j;

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Cell seekToSurvive(Cell[][] current){
        return isLivable(current)? this:null;
    }

    public boolean isLivable(Cell[][] cells){
        switch (neighbors(cells)){
            case 0:
            case 1:
            case 4:
                return false;
            case 2:
                return this==cells[i][j];
        }
        return true;
    }
    public int neighbors(Cell[][] cells){
        int [][] dirs={
                {-1,0},{-1, 1},{0, 1},{ 1, 1},
                { 1,0},{ 1,-1},{0,-1},{-1,-1}
        };
        int count=0;

        for (int i=0;i<8&&count<4;i++){
            int row   =this.i+dirs[i][0];
            int column=this.j+dirs[i][1];

            if (row>-1&&row<cells.length&&column>-1&&column<cells[0].length&&cells[row][column]!=null){
                count++;
            }
        }
        return count;
    }

    public boolean equals(Object obj){
        if (obj==null||getClass()!=obj.getClass()){
            return false;
        }
        final Cell that=(Cell)obj;
        return this.i==that.i&&this.j==that.j;
    }
    public int hashCode(){
        int hash=7;
        hash=59*hash+this.i;
        hash=59*hash+this.j;
        return hash;
    }


}
public class LifeGame {
    public static Cell[][] asCells(int[][] rowData){
        Cell[][] cells=new Cell[rowData.length][rowData[0].length];
        for (int i=0;i<rowData.length;i++){
            for (int j=0;j<rowData[i].length;j++){
                if (rowData[i][j]==1){
                    cells[i][j]=new Cell(i,j);
                }
            }
        }
        return cells;
    }
    public static Cell getOrNew(Cell[][] cells, int i, int j){
        return cells[i][j]==null? new Cell(i,j):cells[i][j];
    }
    public static Cell[][] produce(Cell[][] current){
        Cell[][] next=new Cell[current.length][current[0].length];
        for (int i=0;i<current.length;i++){
            for (int j=0;j<current.length;j++){
                next[i][j]=getOrNew(current,i,j).seekToSurvive(current);
            }
        }
        return next;
    }
    public static void print(Cell[][] cells){
        out.println("Status:....");
        for (Cell[] row: cells){
            for (Cell cell: row){
                out.print(cell==null?" ~":" *");
            }
            out.println();
        }
    }
    public static void main(String[] args) {
        Cell[][] current=asCells(new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 1, 1}});

        print(current);
        int count=0;

        Cell[][] next=produce(current);
        while (!Arrays.deepEquals(current,next)){
            out.println(count++);
            current=next;
            print(current);
            next=produce(current);
        }
    }
}
