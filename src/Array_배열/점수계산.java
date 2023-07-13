package Array_배열;

import java.util.Scanner;

/**
 * 맞은 문제는 1점을 주고, 틀린 문제는 0점을 주되, 연속 맞춘 문제의 n번쨰 문제는 가산점이 n-1점을 부여하는 규칙. 총점.
 */

class Main_7 {

    public int solution(int n, int[] arr) {
        int answer = 0;
        int extra = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] == 1) {
                answer += 1 + extra;
                extra++;
            } else {
                extra = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_7 main = new Main_7();
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(main.solution(n, arr));
    }
}
