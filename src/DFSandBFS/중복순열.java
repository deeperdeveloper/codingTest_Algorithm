package DFSandBFS;

import java.util.Scanner;

class Main_4 {

    static int n,m;
    static int[] arr;

    public void dfs(int level, int k) {
        if(level == m+1) {
            for(int i=1; i<=m; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }
        arr[level] = k;
        for(int i=1; i<=n; i++) {
            dfs(level+1, i);
            if(level == m) break;
        }
    }


    public static void main(String[] args) {
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m+1];
        main.dfs(0,0);
    }
}
