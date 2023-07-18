package recursive_tree_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1번 정점에서 각 정점으로 가는 최소 이동 간선 수를 모두 출력하기. (2가지 방법)
 */
class Main_14 {

    static int n,m;
    static int[] answer;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;


    public void bfs(int x) {
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        ch[x] = 1; //
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                for(int nv : graph.get(cur)) {
                    if(ch[nv] == 0) {
                        ch[nv] = 1;
                        queue.offer(nv);
                        answer[nv] = level+1; //answer[nv] = answer[cur]+1; 로 써도 가능.
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args){
        Main_14 main = new Main_14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점 수
        m = sc.nextInt(); //간선 수
        ch = new int[n+1];
        answer = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());
        for(int k=1; k<=m; k++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        main.bfs(1);
        for(int i=2; i<=n; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}
