package recursive_tree_graph;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 수직선 상 현수의 위치를 s, 송아지의 위치를 e라고 할 때, s-> e까지 아래의 점프를 잘 섞어서 도착할 수 있는 최소 횟수
 *      - 점프는 +1, -1, +5 중 하나만 가능.
 */

class Main_8 {

    public int bfs(int s, int e) {
        int level = 0;
        int[] dir = {-1, 1, 5};
        int[] ch = new int[10001]; //이것이 bfs2()와의 차이점
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int cur = queue.poll();
                if(cur == e) return level;
                ch[cur] = 1;
                for(int k=0; k<3; k++) {
                    if(cur+dir[k]>0 && cur+dir[k] < 10001 && ch[cur+dir[k]] == 0) {
                        if(cur+dir[k] == e) return level+1;
                        queue.offer(cur+dir[k]);
                        ch[cur+dir[k]] = 1; //이 코드가 없으면 시간 초과가 뜸. (즉, offer할 때 방문처리 해서, poll()되기 전이라도, 똑같은 수가 queue에 들어가는 것을 방지)
                    }
                }
            }
            level++;
        }
        return level;
    }

    public int bfs2(int s, int e) {
        int answer = 0;
        int[] dir = {-1,1,5};
        int[] dupli = new int[e+6];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        dupli[s] = 1;
        int len = queue.size();
        while(!queue.isEmpty()){
            for(int i=0; i<len; i++) {
                int cur = queue.poll();
                if(cur == e) return answer;

                for(int j=0; j<3; j++) {
                    if(cur+dir[j] > 0 && cur+dir[j] < e+4 && dupli[cur+dir[j]] != 1) {
                        queue.offer(cur+dir[j]);
                        dupli[cur+dir[j]] = 1;
                    }
                }
            }
            answer++;
            len = queue.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.print(main.bfs(s,e));
    }
}

/**
 * 눈여겨 보아야 할 점.
 *
 * 1. bfs()는 bfs2()에 비해서, 아래의 사항에서 뛰어난 풀이
 *     - 문제의 상황을 모두 다 담아냄. (애초에 10000개의 배열을 설정해서 s와 e가 어떻게 주어지든지 깔끔하게 대처 가능)
 *     - e의 값과 일치하는 값이 cur+dir[k]에 배정되면, 다음 동작과 메모리를 사용하지 않고 즉시 return 한다는 점.
 *
 *
 *
 */