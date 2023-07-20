package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main_12 {

    public int bfs(int n, int m, int[][] box){
        int[] dx = {0,-1,1,0};
        int[] dy = {-1,0,0,1};

        Queue<Point3> queue = new LinkedList<>();
        int level = 0;
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(box[i][j] == 0) cnt++;
                if(box[i][j] == 1) {
                    queue.offer(new Point3(i,j));
                }
            }
        }
        while(!queue.isEmpty()) {
            if(cnt == 0) return level;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point3 cur = queue.poll();
                for(int k=0; k<4; k++) {
                    if(box[cur.x + dx[k]][cur.y+dy[k]] == 0) {
                        cnt--;
                        box[cur.x + dx[k]][cur.y+dy[k]] = 1;
                        queue.offer(new Point3(cur.x+dx[k], cur.y+dy[k]));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        Main_12 main = new Main_12();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] box = new int[n+2][m+2];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<=n+1; i++) {
            box[i][0] = -1;
            box[i][m+1] = -1;
        }
        for(int j=0; j<=m+1; j++) {
            box[0][j] = -1;
            box[n+1][j] = -1;
        }
        System.out.print(main.bfs(n,m,box));
    }
}
