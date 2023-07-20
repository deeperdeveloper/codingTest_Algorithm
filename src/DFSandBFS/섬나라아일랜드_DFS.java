package DFSandBFS;

import java.util.Scanner;

class Main_13 {

    static int[] dx = {-1,0,1,1,-1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int n;
    static int[][] arr;
    static int answer = 0;

    public void dfs(int x, int y) {
        arr[x][y] = 0;
        for(int k=0; k<=7; k++) {
            if(arr[x+dx[k]][y+dy[k]] == 1) dfs(x+dx[k], y+dy[k]);
        }
    }

    public void solution(){
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(arr[i][j] == 1) {
                    answer++;
                    dfs(i,j);
                }
            }
        }
    }

    public static void main(String[] args){
        Main_13 main = new Main_13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+2][n+2];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int k=0; k<=n+1; k++){
            arr[0][k] = 0;
            arr[n+1][k] = 0;
            arr[k][0] = 0;
            arr[k][n+1] = 0;
        }
        main.solution();
        System.out.print(answer);
    }
}
