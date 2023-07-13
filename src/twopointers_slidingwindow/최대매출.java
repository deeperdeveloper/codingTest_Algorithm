package twopointers_slidingwindow;

import java.util.Scanner;

/**
 * n일의 매출기록과, 연속매출 합의 일자를 k일이라 할 때, k일 연속매출 합의 최댓값.
 */
class Main_3 {

    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int subSum = 0;
        int pt1 = 0;
        int pt2 = k;

        //answer, subSum 초깃값 설정
        for(int i=0; i<k; i++) subSum += arr[i];
        answer = Math.max(subSum, answer);

        while(pt2 < n) {
            //다음 sliding window에 대한 로직
            subSum -= arr[pt1++];
            subSum += arr[pt2++];

            answer = Math.max(answer, subSum);
        }
        return answer;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(main.solution(n,k,arr));
    }
}
