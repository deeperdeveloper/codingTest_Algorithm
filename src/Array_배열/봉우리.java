package Array_배열;

import java.util.Scanner;

/**
 * N*N 격자판의 숫자를 입력받을 때, 각 수의 상하좌우보다 모두 큰 수의 경우의 수 출력
 */

class Main_10 {

    public int solution(int n, int[][] arr) {
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        int answer = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                boolean flag = true;
                for(int k=0; k<4; k++) {
                    if(arr[i][j] <= arr[i+dx[k]][j+dy[k]]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

    public int solution2(int n, int[][] arr) {
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        int answer = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int tmp = 0;
                for(int k=0; k<4; k++) {
                    if(arr[i][j] <= arr[i+dx[k]][j+dy[k]]) break;
                    tmp++;
                }
                if(tmp == 4) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_10 main = new Main_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(main.solution(n, arr));
    }
}

/**
 * 1. solution() 과 solution2() 는 풀이가 거의 같다.
 *  - 다만, flag를 활용하는 점을 생각해보면, solution()이 더 깔끔.
 *
 */
