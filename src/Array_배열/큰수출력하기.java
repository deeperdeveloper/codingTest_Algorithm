package Array_배열;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 정수 요소의 배열이 주어질 때 아래의 사항
 * - 배열 내부 요소의 갯수 n과 배열을 입력받을 때, 바로 앞 요소보다 큰 요소를 모두 출력하기
 */
class Main_1 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int k : main.solution(n, arr)) {
            System.out.print(k+ " ");
        }
    }
}
