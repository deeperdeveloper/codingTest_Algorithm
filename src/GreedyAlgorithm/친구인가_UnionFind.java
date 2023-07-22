package GreedyAlgorithm;

import java.util.Scanner;

//unf의 각 원소는, 부모 노드를 가리킨다는 개념에서 풀이를 출발한다.
class Main_6 {

    static int[] unf; //각 원소는 부모 노드를 가리킨다.

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]); //경로 압축
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa!= fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        int sa = sc.nextInt();
        int sb = sc.nextInt();
        int fa = find(sa); //부모 노드를 찾는다.
        int fb = find(sb);
        if(fa == fb) System.out.print("YES");
        else System.out.print("NO");
    }
}

/**
 * Union&Find
 *   - 서로 다른
 *
 */