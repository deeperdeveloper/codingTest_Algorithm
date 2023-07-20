package DFSandBFS;

import java.util.Scanner;

class Main_10 {

    static int[][] arr = new int[7+2][7+2];
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    static int answer = 0;

    public void dfs(int x, int y){
        arr[x][y] = 1;
        if(x==7 && y==7) {
            answer++;
            arr[x][y] = 0;
            return;
        }
        for(int k=0; k<=3; k++) {
            if(arr[x+dx[k]][y+dy[k]] == 0) {
                dfs(x+dx[k], y+dy[k]);
            }
        }
        arr[x][y] = 0;
    }

    public static void main(String[] args){
        Main_10 main = new Main_10();
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<=8; i++) {
            arr[i][0] = 1;
            arr[i][8] = 1;
            arr[0][i] = 1;
            arr[8][i] = 1;
        }
        main.dfs(1,1);
        System.out.print(answer);
    }
}
