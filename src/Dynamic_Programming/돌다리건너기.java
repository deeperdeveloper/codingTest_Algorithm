package Dynamic_Programming;

import java.util.Scanner;

class Main_2 {

    public int solution(int n) {
        int[] da = new int[n+2];
        da[1] = 1;
        da[2] = 2;
        for(int i=3; i<=n+1; i++) {
            da[i] = da[i-1] + da[i-2];
        }
        return da[n+1];
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(main.solution(n));
    }
}
