package recursive_tree_graph;

import java.util.Scanner;

/**
 * {1,2...,n}의 각 부분집합의 원소를 출력하기 (DFS 활용)
 */
class Main_6 {

    public int n;
    public boolean[] arr;

    public void dfs(int k, boolean flag) {
        if(flag == true) arr[k] = true;
        else arr[k] = false;

        if(k==n) {
            for(int i=1; i<=n; i++) {
                if (arr[i] == true) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        dfs(k+1,true);
        dfs(k+1,false);
    }

    public static void main(String[] args) {
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        main.n = sc.nextInt();
        main.arr = new boolean[main.n+1];
        main.dfs(0,false);
    }
}

/**
 * 생각해 볼 사안
 * 1. 나의 아이디어는 아래와 같다.
 *
 *
 *                     D(0)
 *              /               \
 *            D(1)               D(1)
 *          /     \            /       \
 *       D(2)     D(2)       D(2)       D(2)
 *      /   \    /    \     /    \      /   \
 *    D(3) D(3) D(3) D(3) D(3) D(3)  D(3) D(3)
 *
 *
 *    1-1. 트리의 왼쪽을 타면, 해당 숫자를 선택하는 것이고, 트리의 오른쪽을 타면 해당 숫자를 선택하지 않는 것이다.
 *
 * 2. 다른 풀이는 아래에 정리
 *
 */

//다른 풀이
/*class Main_6 {
    static int n;
    static int[] ch;

    public void dfs(int th) {
        if(th == n+1) {
            String tmp = "";
            for(int i=1; i<=n; i++) {
                if(ch[i]==1) tmp += (i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp); // 공집합 제외한 각 부분집합의 모든 원소 출력
        }

        else{
            ch[th] = 1;
            dfs(th + 1); //th를 포함하는 부분집합인 경우
            ch[th] = 0;
            dfs(th + 1); //th를 포함하지 않는 부분집합인 경우
        }
    }

    public static void main(String[] args) {
        Main_6 main = new Main_6();
        n=7;
        ch = new int[n+1];
        main.dfs(1);
    }
}*/

/**
 * <생각해 볼 사안>
 *  1. 최초 생각의 아이디어는, 1~n까지의 각 원소를 부분집합에 담을 때, 담기는 원소는 1로 표시하며 안 담기는 원소는 0으로 표시하는 것을 생각하는 것이 핵심
 *      - 해당 아이디어를 아래 트리로 실현하게 되면 다음과 같다.
 *               D(1)
 *             /    \
 *           D(2)    D(2)
 *          /   \    /   \
 *        D(3) D(3) D(3) D(3)
 *
 *
 *  2. 해당 트리를 토대로, 아래와 같이 DFS()메서드의 큰 틀을 작성할 수 있다.
 *      dfs(n) {
 *          dfs(n+1); // n 포함시
 *          dfs(n+1); // n 미포함시
 *      }
 *  3. 이제, 1번의 아이디어를 통해 dfs(n)을 좀더 구체화시켜보면
 *      dfs(n) {
 *          ch[n] = 1;
 *          dfs(n+1);    //aa번째
 *          ch[n] = 0;
 *          dfs(n+1);    //bb번째
 *      }
 *  추가) stack에서 stack frame은 항상 dfs(1)이 맨 밑에 쌓여있고, dfs(n+1)은 맨 위에 쌓여있다.
 *          -> 각 stack frame에서 "마지막으로 실행된 코드 line"을 통해, n이 포함된 부분집합인지 아닌지 판별 가능하다.
 */