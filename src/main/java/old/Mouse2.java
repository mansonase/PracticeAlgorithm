package old;

import static java.lang.System.out;

interface Boss{
    void take(int[][] maze);
}
public class Mouse2 {

    public static void visit(int[][] maze,Point pt, Point end, Boss boss){
        if (isVisitable(maze, pt)){
            maze[pt.x][pt.y]=1;
            if (isEnd(maze, end)){
                boss.take(maze);
            }else {
                visit(maze, new Point(pt.x, pt.y+1), end, boss);
                visit(maze, new Point(pt.x+1, pt.y), end, boss);
                visit(maze, new Point(pt.x, pt.y-1), end, boss);
                visit(maze, new Point(pt.x-1, pt.y), end, boss);
            }
            maze[pt.x][pt.y]=0;
        }
    }

    private static boolean isVisitable(int[][] maze, Point pt){
        return maze[pt.x][pt.y]==0;
    }
    public static boolean isEnd(int[][] maze, Point end){
        return maze[end.x][end.y]==1;
    }
    public static void main(String[] args) {

        Mouse2.visit(new int[][]{
                        {2, 2, 2, 2, 2, 2, 2, 2, 2},
                        {2, 0, 0, 0, 0, 0, 0, 0, 2},
                        {2, 0, 2, 2, 0, 2, 2, 0, 2},
                        {2, 0, 2, 0, 0, 2, 0, 0, 2},
                        {2, 0, 2, 0, 2, 0, 2, 0, 2},
                        {2, 0, 0, 0, 0, 0, 2, 0, 2},
                        {2, 2, 0, 2, 2, 0, 2, 2, 2},
                        {2, 0, 0, 0, 0, 0, 0, 0, 2},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2}},

                new Point(1, 1), new Point(7, 7),

                new Boss() {
                    @Override
                    public void take(int[][] maze) {
                        for (int[] row : maze) {
                            for (int block : row) {
                                switch (block) {
                                    case 0:
                                        out.print(" ");
                                        break;
                                    case 1:
                                        out.print("o");
                                        break;
                                    case 2:
                                        out.print("X");
                                        break;
                                }
                            }
                            out.println();
                        }
                        out.println();
                    }
                }
        );
    }
}
