package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1. n*n 크기 격자판에서, 인형을 숫자로 입력받는다고 하자. (0은 비어있음을 의미)
 * 2. 이제, 길이 m인 배열에 대해, 이동할 위치(가로 기준)를 입력받자. (이 때 요소는 1~n 범위)
 * 1+2. 2번에서 입력받은 위치의 맨 위 인형을 별도의 긴 통에 넣자. 이 때 같은 인형이 연속하면 터뜨리자
 *
 * 터뜨려진 인형의 갯수를 구하기.
 */

class Main_3 {

    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<m; i++) {
            for(int j=1; j<=n; j++) {
                if(board[j][moves[i]] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[j][moves[i]]);
                        board[j][moves[i]] = 0;
                        break;
                    }
                    int prevTopDoll = stack.peek();
                    int curTopDoll = stack.push(board[j][moves[i]]);
                    if(prevTopDoll == curTopDoll) {
                        answer += 2;
                        stack.pop();
                        stack.pop();
                    }
                    board[j][moves[i]] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public int solution2(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int p : moves) {
            for(int j=1; j<=n; j++) {
                if(board[j][p] != 0) {
                    int tmp = board[j][p];
                    board[j][p] = 0;
                    if(!stack.isEmpty() && stack.peek() == tmp) {
                        answer += 2;
                        stack.pop();
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int k=0; k<m; k++) moves[k] = sc.nextInt();
        System.out.print(main.solution(n,board,m,moves));
    }
}

/**
 * 참고할 만한 사항
 * 1. solution2()의 풀이를 solution1()의 풀이와 비교해서 어떤 부분이 보다 더 깔끔한지 살펴보기
 *
 *
 */


