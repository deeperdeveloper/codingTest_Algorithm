package Array_배열;

import java.util.Scanner;

/**
 * 학생들 n명의 키가 주어질 때, 맨 앞에서 봤을 때 가려지지 않고 보여지는 학생의 총 수
 */
class Main_2 {

    public int solution(int n, int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(max < arr[i]) {
                count++;
                max = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] students = new int[n];
        for(int i=0; i<n; i++) {
            students[i] = sc.nextInt();
        }
        System.out.print(main.solution(n, students));
    }
}
