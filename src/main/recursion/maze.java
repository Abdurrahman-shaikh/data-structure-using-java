package src.main.recursion;

import java.util.ArrayList;
import java.util.List;

public class maze {
    public static void main(String[] args) {
//        System.out.println(maze(3,3,""));

        boolean[][] mat = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };

        mazeWithObstacleBT(0,0,mat,"",0);
    }

    public static List<String> maze(int r, int d, String pattern) {
        int count = 0;
        if (r == 1 && d == 1) {
            List<String> al = new ArrayList<>();
            al.add(pattern);
            System.out.println(pattern);
            return al;
        }
        List<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(maze(r - 1, d, pattern + "D"));
        }
        if (d > 1) {
            list.addAll(maze(r, d - 1, pattern + "R"));
        }

        if (r == d) {
            list.addAll(maze(r-1, d-1,pattern + "Di"));
        }
        return list;
    }

    public static void mazeWithObstacle(int r, int c, boolean[][] mat, String pattern) {
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            System.out.println(pattern);
            return;
        }
        if (r < mat.length - 1) {
            mazeWithObstacle(r + 1, c, mat, pattern + "D");
        }
        if (c < mat[0].length - 1) {
            mazeWithObstacle(r, c + 1, mat, pattern + "R");
        }

//        if (r == c) {
//            mazeWithObstacle(r-1, c-1, mat,pattern + "Di");
//        }
        if(!mat[r][c]) return;
        return;
    }
    public static void mazeWithObstacleBT(int r, int c, boolean[][] mat, String pattern, int count) {
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            System.out.println(pattern + " " + count);
            return;
        }

        if (!mat[r][c]) return;
        mat[r][c] = false;


        if (r < mat.length - 1) {
            mazeWithObstacleBT(r + 1, c, mat, pattern + "D",count+1);
        }

        if (c < mat[0].length - 1) {
            mazeWithObstacleBT(r, c + 1, mat, pattern + "R" ,count + 1);
        }

        if (r > 0) mazeWithObstacleBT(r - 1,c, mat, pattern + "U",count + 1);
        if (c > 0) mazeWithObstacleBT(r ,c - 1, mat,  pattern + "L",count + 1);

        mat[r][c] = true;
//        if (r == c) {
//            mazeWithObstacle(r-1, c-1, mat,pattern + "Di");
//        }
    }
}
