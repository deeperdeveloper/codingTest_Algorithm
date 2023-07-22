package Dynamic_Programming;

import java.util.Scanner;

class Main_1 {

    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++) {
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n];
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.print(main.solution(n));
    }
}
