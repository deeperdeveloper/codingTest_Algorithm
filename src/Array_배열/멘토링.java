package Array_배열;

import java.util.Scanner;

/**
 * 학생 수 n명, 테스트 m를 시행하고 각 테스트마다 학생의 등수를 입력받는다고 하자
 * => 모든 테스트에서 i가 j보다 등수가 높은 학생(i,j)의 쌍의 경우의 수
 */

class Main_12 {

    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        //학생 i와 학생 j가 멘토-멘티 관계가 성립이 가능한지 여부 확인
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int cnt = 0;
                for(int k=0; k<m; k++) {
                    int rankI = 0;
                    int rankJ = 0;
                    for(int a=0; a<n; a++) {
                        if(arr[k][a] == i) rankI = a;
                        if(arr[k][a] == j) rankJ = a;
                    }
                    if(rankI > rankJ) {
                        cnt++;
                    }
                }
                //m번의 테스트 모두 i가 j보다 등수가 높아서, 멘토-멘티 관계가 성립하는 경우
                if(cnt == m) answer++;
            }
        }

        return answer;
    }

    public int solution2(int n, int m, int[][] arr) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                boolean flag = true;
                for(int k=0; k<m; k++) {
                    int rankI = 0;
                    int rankJ = 0;
                    for(int a=0; a<n; a++) {
                        if(arr[k][a] == i) rankI = a;
                        if(arr[k][a] == j) rankJ = a;
                    }
                    //단 한번이라도 j가 i보다 등수가 높거나 같은 경우가 존재 시, 멘토-멘티 관계가 성립할 수 없다.
                    if(rankI <= rankJ) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main_12 main = new Main_12();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //학생 수
        int m = sc.nextInt(); //테스트 횟수
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(main.solution(n,m,arr));
    }
}
