package sorting_searching;

import java.util.Scanner;
import java.util.Arrays;

/**
 * n개의 숫자를 입력받을 때, 중복된 숫자가 존재하면 D를 출력하고 그렇지 않으면 U를 출력
 */
class Main_5 {

    public String solution(int n, int[] arr){
        String answer = "U";
        Arrays.sort(arr);
        for(int k=0; k<n-1; k++) {
            if(arr[k] == arr[k+1]) return "D";
        }
        return answer;
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print(main.solution(n,arr));
    }
}