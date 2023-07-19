package DFSandBFS;

import java.util.Scanner;

class Main_7 {

    static int n,r;
    static int[][] arr;

    public int dfs(int n, int r) {
        if(r==0 || n==r) return 1;
        if(arr[n][r] > 0) return arr[n][r];
        return arr[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }

    public static void main(String[] args) {
        Main_7 main = new Main_7();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        arr = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++) {
            arr[i][0] = 1;
            arr[0][i] = 1;
        }
        System.out.print(main.dfs(n, r));
    }
}
