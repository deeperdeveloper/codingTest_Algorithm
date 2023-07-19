package DFSandBFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main_5 {

    static int n,m;
    static Integer[] arr;
    static int answer = Integer.MAX_VALUE;

    public void dfs(int level, int sum, int p) {
        if(sum > m) return;
        if(level >= answer) return; //이거 없으면 시간 초과 뜸.
        if(sum == m) {
            answer = Math.min(answer, level);
            return;
        }

        for(int i=p; i<=n-1; i++) {
            dfs(level+1, sum+arr[i], i);
        }
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n+1];
        for(int i=0; i<=n-1; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder()); //최적화 요건 (뭐 이거 빼도 시간 초과는 안 뜸)
        m = sc.nextInt();
        main.dfs(0,0,0);
        System.out.print(answer);
    }
}