package DFSandBFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Main_11 {

    static int[][] graph = new int[7+2][7+2];
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    public int bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        graph[point.x][point.y] = 1; //이렇게 강제로 초깃값 지정하는 것보다, 합쳐서 넣을 수 있는 방법이 있을까?
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point cur = queue.poll();
                for(int k=0; k<=3; k++) {
                    if(cur.x + dx[k] == 7 && cur.y + dy[k] == 7) return level+1;
                    if(graph[cur.x + dx[k]][cur.y + dy[k]] == 0) {
                        queue.offer(new Point(cur.x + dx[k], cur.y + dy[k]));
                        graph[cur.x + dx[k]][cur.y + dy[k]] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        Main_11 main = new Main_11();
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<=7; i++) {
            for(int j=1; j<=7; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<=8; i++) {
            graph[i][0] = 1;
            graph[i][8] = 1;
            graph[0][i] = 1;
            graph[8][i] = 1;
        }
        System.out.print(main.bfs(new Point(1,1)));
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}