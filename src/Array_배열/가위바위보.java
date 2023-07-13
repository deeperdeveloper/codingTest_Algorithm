package Array_배열;

import java.util.Scanner;

/**
 * n판의 가위 바위 보에서 승자를 출력
 */
class Main_3 {
    public String[] solution(int n, int[] arrA, int[] arrB) {
        String[] answer = new String[n];

        for(int k=0; k<n; k++) {
            if(arrA[k] == arrB[k]) answer[k] = "D";
            else if(arrA[k] == 1 && arrB[k] == 3 || arrA[k] == 2 && arrB[k] == 1 || arrA[k] == 3 && arrB[k] == 2) answer[k] = "A";
            else answer[k] = "B";
        }
        return answer;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for(int i=0; i<n; i++) {
            arrA[i] = sc.nextInt();
        }
        for(int j=0; j<n; j++) {
            arrB[j] = sc.nextInt();
        }
        for(String result : main.solution(n, arrA, arrB)) {
            System.out.println(result);
        }
    }
}
