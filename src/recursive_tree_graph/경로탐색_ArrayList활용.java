package recursive_tree_graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * n개의 노드(1~n번 노드)와 m개의 간선이 주어진 방향 그래프에서, 연결관계를 입력받았을 때 1번 노드에서 n번 노드까지 가는 경로의 수 출력
 * (인접리스트 활용)
 */
class Main_13 {

    static int n,m;
    static int answer;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public void dfs(int x) {
        if(x==n) {
            answer++;
            return;
        }
        ch[x] = 1;
        for(int nv : graph.get(x)) {
            if(ch[x] == 0) {
                dfs(nv);
                ch[nv] = 0;
            }
        }
        ch[x] = 0;
    }

    public static void main(String[] args){
        Main_13 main = new Main_13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점 수
        m = sc.nextInt(); //간선 수
        ch = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>()); //중요! index와 꼭지점 맞추기
        for(int k=1; k<=m; k++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        main.dfs(1);
    }
}

/**
 * 생각해 볼 사안
 * 1. 인접리스트를 쓰는 경우 : 정점의 수 n이 아주 클 때 활용한다.
 *          => i번 노드에서 j번 노드로 연결된 간선의 갯수를 구하면 무조건 n번 따져야 한다.
 *          => 인접행렬을 활용한다면, 모든 노드에 대해서 다 따져야 하며, O(n^2)번의 시간복잡도가 소요됨.
 *          => 따라서, 아래와 같이 인접리스트를 활용한다면 작업 시간을 줄일 수 있다.
 *
 *          <인접리스트 예시>
 *          1 ->  2,3,4
 *          2 ->  1,3,5
 *          3 ->  4
 *          4 ->  2,5
 *          5 ->  -
 *
 * => 이 경우에 대해, 코드로 구현하면 된다.
 *
 */