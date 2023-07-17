package recursive_tree_graph;

import java.util.Scanner;

/**
 * 10진수 n을 입력받을 때, 2진수로 출력하기
 */
class Main_2 {

    public void dfs(int n) {
        if(n == 1) {
            System.out.print(1);
            return;
        }
        dfs(n/2);
        System.out.print(n % 2);
    }


    public static void main(String[] args) {
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        main.dfs(n);
    }
}
