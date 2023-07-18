package recursive_tree_graph;

import java.util.Scanner;

/**
 * 정점 수 n과 간선 수 m을 입력받고, 그래프에서 연결관계를 입력받았을 때, 1번 정점에서 n번 정점까지 가는 경로의 가짓수를 출력.
 *
 */

class Main_12 {

    static int[][] graph;
    static int[] ch;
    static int n; //정점 수
    static int m; //간선 수
    static int answer = 0;

    public void dfs(int x) {
        if(x == n) {
            answer++;
            return;
        }
        ch[x] = 1;
        for(int i=1; i<=n; i++) {
            if(ch[i]==0 && graph[x][i]==1) {
                dfs(i);
            }
        }
        ch[x] = 0;
    }

    public static void main(String[] args){
        Main_12 main = new Main_12();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        main.dfs(1);
        System.out.print(answer);
    }
}

/**
 * 생각해 볼 사안.
 * 1. 경로의 정의에 의해, 한번 방문한 노드는 다시 재방문하지 않는다.
 * 2. 이 문제 풀이의 핵심은, 모든 가능한 경우에 대해 트리를 그려보고, 문제 조건에 맞게 트리를 재구성하는 것이다.
 *      예) 1번 노드에서 갈 수 있는 노드는 2,3,4번이나  일단은 아래와 같이 그리자.
 *               1
 *            // | \\
 *           1 2 3 4 5
 *           => 이후, 1번 노드와 5번 노드를 제거하는 조건을 생각해내면 된다.
 * 3. dfs를 적용할 때, 각 경우에 대해 스택 프레임이 쌓이고 pop 되는 과정을 상상하면 좀 더 코드를 유연하게 짤 수 있을 것이다.
 *      => 위의 (*)line의 코드에서는 dfs(1) 스택 프레임 바로 위에 쌓이는 스택 프레임의 경우가 3가지 존재. (dfs(2), dfs(3), dfs(4))
 *      => 각 경우에 대해, dfs(2)가 pop되고 dfs(3)이 쌓이고, dfs(3)이 pop되고 dfs(4)가 쌓이는 과정을 상상하면 dfs를 어떻게 쓸 지 더 명확하게 감이 올 것이다.
 *
 *
 */
