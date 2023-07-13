package twopointers_slidingwindow;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 오름차순으로 정렬된 두 배열을 입력받을 때, 두 배열을 합쳐 오름차순으로 출력
 */
class Main_1 {

    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while(p1 < n && p2 < m) {
            if(arr1[p1] >= arr2[p2]) {
                answer.add(arr2[p2]);
                p2++;
            } else {
                answer.add(arr1[p1]);
                p1++;
            }
        }
        if(p1 == n) {
            while(p2<m) {
                answer.add(arr2[p2]);
                p2++;
            }
        } else {
            while(p1<n) {
                answer.add(arr1[p1]);
                p1++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int j=0; j<m; j++) {
            arr2[j] = sc.nextInt();
        }
        for(int k : main.solution(n,arr1,m,arr2)) {
            System.out.print(k+ " ");
        }
    }
}
