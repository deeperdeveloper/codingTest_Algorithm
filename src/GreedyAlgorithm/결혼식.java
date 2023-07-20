package GreedyAlgorithm;

import java.util.Scanner;


class Main_3 {

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[72+1];
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int k=a; k<b; k++) arr[k]++;
        }
        int max = -1;
        for(int i=0; i<73; i++) {
            if(max < arr[i]) max = arr[i];
        }
        System.out.print(max);
    }
}

/**
 * 아래의 풀이도 가능하다. 다만, 모든 경우를 고려하였기에, 위에서 적용한 Greedy Algorithm 보다는 효율성이 뒤떨어진다.
 *
 */