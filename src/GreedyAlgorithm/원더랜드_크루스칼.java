package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Main_7 {

    static int v,e, answer;
    static int[] unf;

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if(fv1 != fv2) unf[fv1] = fv2;
    }

    public static void main(String[] args) {
        Main_7 main = new Main_7();
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        ArrayList<Edge2> arr = new ArrayList<>();
        unf = new int[v + 1];
        for(int i=1; i<=v; i++) unf[i] = i;
        for(int j=1; j<=e; j++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            arr.add(new Edge2(v1, v2, cost));
        }
        Collections.sort(arr); //cost 별로 오름차순 정렬
        for(Edge2 e : arr) {
            int fa = find(e.v1);
            int fb = find(e.v2);
            if(fa!=fb) {
                union(e.v1, e.v2);
                answer += e.cost;
            }
        }
        System.out.print(answer);
    }
}

class Edge2 implements Comparable<Edge2>{
    int v1;
    int v2;
    int cost;

    Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge2 e) {
        return this.cost - e.cost;
    }
}


/**
 * 크루스칼 알고리즘
 *
 * 1. 내용
 *    - 최소 스패닝 트리(MST)를 찾기에는 아래의 알고리즘대로 적용하면 된다.
 *
 *      1) 그래프의 모든 간선을 가중치의 오름차순으로 정렬한다
 *      2) 1)에서의 간선을 1개씩 트리 구조를 유지하면서 추가하되, 아래 조건에 따른다.
 *         - 간선을 추가할 때, 트리 구조가 성립하지 않으면(=사이클이 생기면), 해당 간선은 건너뛰고 다음 간선에 대해 추가 작업을 진행한다.
 *
 *      3) 2)의 과정을 반복하다 보면, 모든 정점이 연결되어 있으면서 가중치 합이 최소인 MST가 완성된다.
 *
 *
 *      1-1. 시간복잡도. (추후 정리)
 *
 *          1)
 *
 *          2)
 *
 *      1-2. 증명
 *
 *          1) (귀류법) 만약 크루스칼 알고리즘으로 찾은 스패닝 트리가 MST가 아니라고 가정하자.
 *              1)-1. 이제, 크루스칼 알고리즘으로 찾은 경로에는 속하지만, MST에 속하지 않은 간선의 양 꼭짓점을 u,v라고 하자. 그리고 해당 간선을 p라고 하자.
 *
 *          2) MST 상에서, u와 v를 잇는 경로는 존재할 것이며, p는 해당 경로상에 존재하지 않음은 자명하다.
 *
 *          3) p의 가중치보다 큰 간선이, 2)의 경로(u와 v를 잇는 경로)에 반드시 존재해야 한다. (그렇지 않으면, 크루스칼 알고리즘만으로 p를 포함할 수 없기 때문이다)
 *              3) - 1 해당 간선을 x라고 하자. (따라서, x는 MST에 속해 있어야 한다)
 *          4) x를 제거하고 p를 넣어도, 스패닝 트리가 성립하게 되며, 이 때 (x의 가중치) > (p의 가중치) 이므로, 기존의 MST의 간선의 가중치 합보다 더 작은 가중치 합인 MST가 생긴다. (모순!)
 *
 *
 *
 *
 */