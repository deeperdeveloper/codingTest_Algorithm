package DFSandBFS;

import java.util.Scanner;

//함정이 많은 문제. 꼭 다시 볼 것
class Main_8 {

    static int n,f;
    static int[] comb;
    static int[] answer;
    static int[] ch;
    boolean flag = false;

    public void dfs(int level, int sum) {
        if(flag || sum > f) return;
        if(level == n) {
            if(sum ==f) {
                flag = true;
                for(int k : answer) System.out.print(k + " ");
            }
            return;
        }

        for(int i=1; i<=n; i++) {
            if(ch[i] == 0) {
                ch[i] = 1;
                answer[level] = i;
                dfs(level+1, sum+ comb[level] * i); //여기까지, i를 활용하여 계산까지 다 끝마치고, 다음 스택 프레임으로 나간다.
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args){
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        comb = new int[n];
        ch = new int[n+1];
        answer = new int[n];
        main.combFill(); //조합수 채워넣기
        main.dfs(0,0);
    }

    private void combFill() {
        comb[0] = 1;
        comb[1] = n-1;
        for(int i=2; i<=n-1; i++) comb[i] = comb[i-1] * ((n-1)-i+1) / i;
    }
}


//아래의 풀이는 틀린 풀이
//answer = {1,2,3,0} 도 가능하게 되기 때문에, 무조건 answer를 끝까지 다 돌려야 한다.
//어떻게 하면 실수 안 할지 생각해보기

/**
 *
 * package DFSandBFS;
 *
 * import java.util.Scanner;
 *
 * class Main_8 {
 *
 *     static int n,f;
 *     static int[] comb;
 *     static int[] answer;
 *     static int[] ch;
 *     boolean flag = false;
 *
 *     public void dfs(int level, int sum) {
 *         if(flag || sum > f) return;
 *         else if(sum == f) {
 *             flag = true;
 *             for(int k : answer) System.out.print(k + " ");
 *             return;
 *         }
 *         if(level == n) return;
 *
 *         for(int i=1; i<=n; i++) {
 *             if(ch[i] == 0) {
 *                 ch[i] = 1;
 *                 answer[level] = i;
 *                 dfs(level+1, sum+ comb[level] * i);
 *                 ch[i] = 0;
 *             }
 *         }
 *     }
 *
 *     public static void main(String[] args){
 *         Main_8 main = new Main_8();
 *         Scanner sc = new Scanner(System.in);
 *         n = sc.nextInt();
 *         f = sc.nextInt();
 *         comb = new int[n];
 *         ch = new int[n+1];
 *         answer = new int[n];
 *         main.combFill(); //조합수 채워넣기
 *         main.dfs(0,0);
 *     }
 *
 *     private void combFill() {
 *         comb[0] = 1;
 *         comb[1] = n-1;
 *         for(int i=2; i<=n-1; i++) comb[i] = comb[i-1] * ((n-1)-i+1) / i;
 *     }
 * }
 *
 *
 */