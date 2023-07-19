package DFSandBFS;

import java.util.Scanner;

class Main_2 {

    static int c;
    static int n;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;

    public void dfs(int level, int sum) {
        if(sum > c) return;
        answer = Math.max(answer, sum);
        if(level == n) return;
        dfs(level+1, sum+arr[level+1]);//arr[level]을 선택하는 경우
        dfs(level+1, sum); //arr[level]을 선택하지 않는 경우
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
        main.dfs(0,0);
        System.out.print(answer);
    }
}
