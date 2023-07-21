package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘
 */
class Main_5 {

    public void solution(int startVertex ,int n, int m, ArrayList<ArrayList<Edge>> arrList) {
        //처음 시작점에서 가장 작은 Edge 선택

        //기존 저장되어 있던 dis[] 배열에 저장

        //
    }

    public static void main(String[] args) {
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //정점 수
        int m = sc.nextInt(); //간선 수
        ArrayList<ArrayList<Edge>> arrList = new ArrayList<>();
        for(int i=0; i<=n; i++) arrList.add(new ArrayList<>());
        for(int j=0; j<m; j++) {
            int s = sc.nextInt();
            int vertex = sc.nextInt();
            int cost = sc.nextInt();
            arrList.get(s).add(new Edge(vertex, cost));
        }
        main.solution(1, n, m, arrList);
    }
}

class Edge {
    int vertex;
    int cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

/**
 * 다익스트라 알고리즘
 *
 * 1. 명제
 *    - 시작점에서 아래의 과정을 거쳐 각 정점까지의 최단거리를 구하자.
 *      1) 시작점에서 바로 이어지는 꼭지점에 대해 거리를 저장
 *          1)-1. 1)에서 저장한 거리 값들 중, 가장 작은 거리값인 꼭지점 a에 대해 다음 과정 진행
 *      2) 1)에서 구한 꼭짓점 a에서, 다음 꼭짓점까지의 거리 중 가장 작은 거리를 가지는 꼭짓점을 선별 (b라고 하자)
 *      3) 시작점과 꼭짓점 b까지의 거리는 아래의 식으로 구해진다.
 *          Math.min(시작점 ~ a까지 거리 + b ~ a까지 거리, 1)과정에서 저장한 거리값(시작점 ~ b까지 거리))
 *      4) 꼭짓점 b에서 2) ~ 3) 과정을 반복하여 완성
 *
 *
 *    1-1. 증명
 *    - 증명하고자 하는 명제 : 다익스트라 알고리즘을 활용하여 발견한 경로는, 반드시 시작점 - 해당점까지의 최단경로이다.
 *       - 증명)
 *          1) (귀류) 다익스트라 알고리즘을 활용하여 발견한 경로가, 최단 경로가 아닌 경우가 존재한다고 해 보자.
 *          2) 1)에서의 경로의 종점을 v라 할 때, 1)에서의 경로를 이루는 정점의 집합을 A라하고, 그 외의 집합을 B라 하자.
 *              2)-1. 이 때, 시작점 - (B의 집합의 점) - v 까지의 경로가 최단경로가 되는 B의 집합의 점 b가 존재한다.
 *                     => 이 b는, (존재한다고 가정하는) 또다른 최단경로에서의 정점 중, B집합에 속하는 제일 첫번째 정점이라고 하자.
 *              2)-2. 여기서, A에 속하는 점을 a라고 할 때, dist[a] < dist[v] 여야만 한다. (다익스트라 알고리즘에 의해서)
 *                   ** dist[x]는, 다익스트라 알고리즘에 의해 구해진, 시작점에서 x까지의 거리이다.
 *          3) 이 때, dist[b] > dist[v] 여야 한다. 그렇지 않으면, b는 A에 속하기 때문이다.
 *          4) 그런데 시작점에서 b까지 가는 경로도 최단 경로여야 하므로 (전체 경로가 최단 경로이니까), dist[b] < dist[v]가 반드시 성립해야 한다.
 *
 *          3)과 4)가 모순이므로, 귀류법에 의해 증명이 된다.
 *
 *          - 증명 출처 : https://kasterra.github.io/shortestPath1/
 *          
 *          
 *    1-2. 시간복잡도
 *      - 추후에 정리
 *
 *
 */