package DFSandBFS;

import java.util.Scanner;

class Main_6 {

    static int n,m;
    static int[] arr;
    static int[] ch;
    static int[] pm; //생각해내기!

    public void dfs(int level) {
        if(level == m) {
            for(int i=0; i<m; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int k=0; k<n; k++) {
            if(ch[k] == 0) {
                ch[k] = 1;
                pm[level] = arr[k];
                dfs(level + 1);
                ch[k] = 0;
                pm[level] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        main.dfs(0);
    }
}
