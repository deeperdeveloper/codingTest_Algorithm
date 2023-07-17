package recursive_tree_graph;

import java.util.Scanner;

/**
 * n 입력 시, n!을 구하는 프로그램 작성
 */
class Main_3 {

    public int dfs(int n) {
        if(n==1) return 1;
        return n * dfs(n-1);
    }

    public static void main(String[] args) {
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(main.dfs(n));
    }
}

/**
 * 추가적으로 고려해 볼 사안
 * 1. 위의 재귀식을 꼬리재귀 형태로 바꾸고 난 후, decompile 해서 재귀 형태가 사라졌는지 확인해보기
 *    (자바에서는 꼬리재귀를 지원하지 않는다고 하는데, 진짜 그런지 확인해볼 것)
 *
 *
 */
