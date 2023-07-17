package recursive_tree_graph;

import java.util.Scanner;

/**
 * 재귀함수를 이용하여, n을 입력 시 1,2,3, ... ,n 이 출력되도록 하기
 */

class Main_1 {

    public void dfs(int n) {
        if(n == 0) return;
        else {
            dfs(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        main.dfs(n);
    }
}

/**
 * 배워야 할 사항
 *
 * 1. DFS
 *    - 스택 프레임이 쌓이는 원리를 활용ㅇ
 *      - 각 스택 프레임에는 다음의 정보가 저장된다. (매개변수, 지역변수, "실행을 할 위치")
 *
 *
 */