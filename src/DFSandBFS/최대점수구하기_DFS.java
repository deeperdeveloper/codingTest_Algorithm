package DFSandBFS;

import java.util.Scanner;

class Main_3 {

    static int n;
    static int m;
    static int[] arr1;
    static int[] arr2;
    static int answer = 0;

    public void dfs(int index, int scoreSum, int timeSum) {
        if(timeSum > m) return;
        answer = Math.max(scoreSum, answer);
        if(index == n) return;
        dfs(index+1, scoreSum+arr1[index+1], timeSum+arr2[index+1]);
        dfs(index+1, scoreSum, timeSum);
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr1 = new int[n+1];
        arr2 = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }
        main.dfs(0,0,0);
        System.out.print(answer);
    }
}
