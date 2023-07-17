package recursive_tree_graph;

import java.util.Scanner;

/**
 * n을 입력 시, 피보니치 수열 1~n항을 출력하기
 * 
 */
class Main_4 {

    private static int[] fibo;

    public int dfs(int n) {
        if(fibo[n] > 0) return fibo[n];
        if(n==1 || n==2) {
            fibo[n] = 1;
            return fibo[n];
        }
        return fibo[n] = dfs(n-1) + dfs(n-2);
    }


    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        main.dfs(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}

/**
 * 참고할 만한 사항
 * 1. 메모이제이션 활용 (fibo에 dfs()의 결과물을 저장하여, 불필요한 재귀를 수행하는 것을 방지)
 *
 *
 */