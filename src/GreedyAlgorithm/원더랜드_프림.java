package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main_8 {

    public static void main(String[] args) {
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[] ch = new int[v+1];
        ArrayList<ArrayList<Edge3>> arr = new ArrayList<>();
        for(int i=0; i<=v; i++) arr.add(new ArrayList<>());
        for(int j=0; j<e; j++) {
            int startVtx = sc.nextInt();
            int endVtx = sc.nextInt();
            int cost = sc.nextInt();
            arr.get(startVtx).add(new Edge3(endVtx, cost));
            arr.get(endVtx).add(new Edge3(startVtx, cost));
        }
        PriorityQueue<Edge3> pq = new PriorityQueue<>();
        pq.offer(new Edge3(1, 0));
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge3 curEdge = pq.poll();
            int tmpVertex = curEdge.endVtx;
            int tmpCost = curEdge.cost;
            if(ch[tmpVertex] == 0) {
                ch[tmpVertex] = 1;
                answer += tmpCost;
                for(Edge3 eg : arr.get(tmpVertex)) {
                    if(ch[eg.endVtx] != 1) {
                        pq.offer(eg);
                    }
                }
            }
        }
        System.out.print(answer);
    }
}

class Edge3 implements Comparable<Edge3> {

    int endVtx;
    int cost;

    public Edge3(int endVtx, int cost) {
        this.endVtx = endVtx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge3 e) {
        return this.cost - e.cost;
    }
}


/**
 * 프림 알고리즘
 * 1. 아래의 과정을 통해, MST를 추출해낸다.
 *     a) 아무 정점 1개를 출발점으로 잡고 시작. (이 때, (1,0)을 최초로 priorityQueue에 offer한 이유이다)
 *     b) a)의 정점에서 출발하여, 다른 정점 y까지의 가능한 간선의 모든 경우를 priorityQueue에 저장
 *     c) b)의 과정에 의해 priorityQueue에 있는 객체 중, 가장 첫번째 객체를 poll함.
 *        => 만약, 이전에 방문한 이력이 있다면, 방문 이력이 없는 객체를 뽑을 때까지 그 다음 객체를 poll한다.
 *     d) c)의 거리 비용을 정답 answer에 추가하며, c)의 poll한 edge에서 연결된 또다른 꼭지점에서 이어진 edge를 priorityQueue에 저장
 *     e) c) ~ d) 과정을 반복. (queue가 완전히 empty될 때까지)
 *
 *     1-1. 증명
 *          - 증명하고자 하는 명제
 *              1) MST의 집합을 A라고 하자. 여기서 V는 그래프 전체의 정점의 집합이며 F'은 MST를 이루는 간선의 집합이라고 하자.
 *                  - F'은 MST의 원소마다 달라질 수 있다.
 *              2) Y⊂V, F⊂F'⊂E이며, (Y,F)은 promising set 이라 하자.
 *              이 때, 프림 알고리즘에 선택된 e∈E 에 대해, F와 {e} 의 합집합은 promising set이다.
 *
 *          - 증명
 *              1) e가 F'의 원소인 경우
 *                  => F와 {e}의 합집합이 F'의 부분집합이 된다. 즉, F와 {e}의 합집합은 promising set
 *              2) e가 F'의 원소가 아닌 경우
 *                  => 해당 경우에 대해서는 모순의 결론이 나오거나, 가중치 합이 MST와 같은 또다른 spanning tree를 만들 수 있다는 결론으로 귀결됨을 보여서 증명을 완료할 것이다.
 *                  => F'과 {e} 의 합집합은 cycle을 이루게 된다.
 *                  => 해당 cycle은 e를 포함하며, e를 제외한 간선 중, 가중치가 e보다 크거나 같은 간선(e')이 해당 cycle 내에 반드시 존재해야 한다.
 *                  (이는 프림알고리즘의 원리에 의해, e'이 e보다 나중에 선택되기 때문이다)
 *                  => F'∪{e} - {e'} 역시 spanning tree이다.
 *
 *                  i) e의 가중치 < e'의 가중치
 *                      => F'∪{e} - {e'} 는 기존의 MST보다 작은 spanning tree이다. 이는 F'이 MST 라는 것에 모순 (모순)
 *
 *                  ii) e의 가중치 = e'의 가중치 (이 경우만 가능)
 *                      => F'∪{e} - {e'} 는 가중치가 동일한 spanning tree이다.
 *                      => F'∪{e} - {e'} 의 부분집합은 promising subset이며, e'는 F의 원소가 아니므로, F ∪ {e}는 F'∪{e} - {e'}의 부분집합.
 *                      => F와 {e}의 합집합은 promising set
 *
 *
 *          - 증명 출처
 *              - https://waytocse.tistory.com/37
 *
 *     1-2. 시간복잡도
 *
 *
 */