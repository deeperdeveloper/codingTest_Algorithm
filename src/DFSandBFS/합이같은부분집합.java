package DFSandBFS;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class Main_1 {


    static Integer[] arr;
    static int[] ch;
    static int sum;
    static int tmp = 0;
    static String answer = "NO";


    public void dfs(int x){
        if(tmp + x == sum) {
            answer = "YES";
            sum = -1;
            return;
        }
        else if(tmp + x > sum) return;

        tmp += x;
        for(int k : arr) {
            if(k<x) {
                dfs(k);
            }
        }
        tmp -= x;
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ch = new int[n];
        arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<n; i++) sum += arr[i];
        if(sum % 2 == 1) {
            System.out.print(answer);
            return;
        }
        sum = sum / 2;
        main.dfs(arr[0]);
        System.out.print(answer);
    }
}

//답은 맞췄는데 반성을 해야 하는 부분이 많이 보임. 너무 절차지향적이다.
