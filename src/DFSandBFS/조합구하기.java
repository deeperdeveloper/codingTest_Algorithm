package DFSandBFS;

import java.util.Scanner;

//약간 hard 했음

class Main_9 {

    static int n,m;
    static int[] arr;
    static int[] answer;

    public void dfs(int level, int i) {
        if(level == m) {
            for(int p : answer) System.out.print(p+ " ");
            System.out.println();
            return;
        }
        for(int k=i; k<n; k++) {
            answer[level] = arr[k];
            dfs(level+1, k+1);
        }
    }

    public static void main(String[] args) {
        Main_9 main = new Main_9();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n]; //자연수 목록 n개를 입력받음
        answer = new int[m]; //n개 중 m개 뽑은 결과물을 출력
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        main.dfs(0,0);
    }
}
