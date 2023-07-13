package Array_배열;

import java.util.Scanner;

/**
 * nxn 격자판에서, 가로합 세로합 대각선 합 중 가장 큰 값 출력
 */

class Main_9 {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        int sum1, sum2;

        for(int i=0; i<n; i++) {
            sum1 = 0;
            sum2 = 0;
            for(int j=0; j<n; j++) {
                sum1 += arr[i][j]; //세로 합
                sum2 += arr[j][i]; //가로 합
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = 0;
        sum2 = 0;
        for(int k=0; k<n; k++) {
            sum1 += arr[k][k];
            sum2 += arr[k][n - 1 - k];

            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        return answer;
    }

    public int solution2(int n, int[][] arr) {
        int max = 0;
        int tmp = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                tmp += arr[i][j];
            }
            max = Math.max(max, tmp);
            tmp = 0;
        }

        for(int j=0; j<n; j++) {
            for(int i=0; i<n; i++) {
                tmp += arr[i][j];
            }
            max = Math.max(max, tmp);
            tmp = 0;
        }

        for(int k=0; k<n; k++) {
            tmp += arr[k][k];
            max = Math.max(max,tmp);
            tmp = 0;
        }

        for(int t=0; t<n; t++) {
            tmp += arr[t][n-1-t];
            max = Math.max(max,tmp);
            tmp = 0;
        }

        return max;
    }

    public static void main(String[] args){
        Main_9 main = new Main_9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt(); //세로로 i번째, 가로로 j번째의 원소를 입력받는다.
            }
        }
        System.out.print(main.solution(n,arr));
    }
}

/**
 * 풀이에 참고할 사항
 * 1. 반복문을 줄이기 위해서, solution2() 외에 solution() 풀이를 참조하면 좋음
 *   - i와 j를 유연하게 쓸 수 있는 사고를 기르기.
 *
 * 2. arr[2][5] = {{1,2,3,4,5}, {0,6,7,8,9}} 의 모양이다.
 *      => (1 2 3 4 5
 *          0 6 7 8 9)
 *      => arr[1][2] = 7
 *
 */
