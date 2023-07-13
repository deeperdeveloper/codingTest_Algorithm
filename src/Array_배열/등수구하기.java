package Array_배열;

import java.util.Scanner;

/**
 * n명의 국어 점수가 입력될 때, 각자의 등수를 출력
 */

class Main_8 {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i]++; //1등부터 시작
            for(int j=i+1; j<n; j++) {
                if(arr[i] < arr[j]) answer[i]++;
                if(arr[i] > arr[j]) answer[j]++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int k : main.solution(n,arr)){
            System.out.print(k + " ");
        }
    }
}
