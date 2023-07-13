package Array_배열;

import java.util.Scanner;

/**
 * n명의 학생이 1~5학년 동안 속한 반의 숫자를 입력받을 때, 제일 많은 학생과 같은 반을 한 학생을 반장으로 선정하여 출력
 */
class Main_11 {

    public int solution(int n, int[][] arr) {
        int cnt = 0;
        int cntMax = Integer.MIN_VALUE;
        int answer = 1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=0; k<5; k++) { //i번 학생과 j번 학생을 1~5학년 떄까지 같은 반을 했다면, cnt에 1을 추가하고 다른 j번 학생과 비교
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break; //중요!
                    }
                }
            }
            //i번 학생이 반장이 될 수 있는지 여부 판단.
            if(cnt > cntMax) {
                cntMax = cnt;
                answer = i;
            }
            cnt = 0;
        }
        return answer;
    }

    public int solution2(int n, int[][] arr) {
        int[][] relationArr = new int[n+1][n+1];
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        for(int j=0; j<5; j++) {
            for(int i=1; i<n+1; i++) {
                for(int k=1; k<n+1-i; k++) {
                    if(arr[i][j] == arr[i+k][j]) {
                        relationArr[i][i+k] = 1;
                        relationArr[i+k][i] = 1;
                    }
                }
            }
        }
        int tmp = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                tmp += relationArr[i][j];
            }
            if(sum < tmp) {
                sum = tmp;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_11 main = new Main_11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][5];
        for(int i=1; i<n+1; i++){
            for(int j=0; j<5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(main.solution(n,arr));
    }
}

/**
 * 참고할 만한 사항.
 * 1. solution() 은 반복문을 어떻게 쓰는지 생각하는 게 핵심
 *  - 다시 보기.
 *
 * 2. solution2()는 학생과의 관계를 저장하는 2차원 배열을 별도로 만들었다는 것이 핵심
 *
 *
 */