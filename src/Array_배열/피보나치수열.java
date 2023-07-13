package Array_배열;

import java.util.Scanner;
/**
 * n을 입력받을 때, 피보나치 수열을 1항 ~ n항 까지 출력
 */

class Main_4 {

    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0]=1;
        answer[1]=1;
        for(int j=2; j<n; j++) {
            answer[j] = answer[j-1] + answer[j-2];
        }
        return answer;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int k : main.solution(n)) {
            System.out.print(k+" ");
        }
    }
}
