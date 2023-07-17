package sorting_searching;

import java.util.Scanner;
import java.util.Arrays;

/**
 * N개의 마구간에 C개의 말을 넣을 때, 가장 가까운 두 말 사이의 거리가 최대가 되게끔 말을 배치하자. 이 경우, 해당 거리를 출력
 * (N개의 마구간의 위치를 입력받는다)
 */

class Main_10 {

    public int count(int mid, int[] arr) {
        int cnt = 1;
        int xi = arr[0];
        for(int h : arr) {
            if(xi + mid <= h) {
                cnt++;
                xi = h;
            }
        }
        return cnt;
    }

    //solution2()를 리팩토링 한 코드
    public int solution(int n, int[] arr, int c) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1]-arr[0];
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(mid, arr) >= c) {
                lt = mid + 1;
                answer = mid;
            } else rt = mid-1;
        }
        return answer;
    }

    public int solution2(int n, int[] arr, int c){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1]-arr[0];
        while(lt<=rt){
            int mid = (lt+rt)/2;
            int cnt = 1;
            int xi = arr[0];
            for(int h : arr) {
                if(xi + mid <= h) {
                    cnt++;
                    xi = h;
                }
            }
            if(cnt >= c) {
                lt = mid + 1;
                answer = mid;
            } else rt = mid-1;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_10 main = new Main_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int c = sc.nextInt();
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print(main.solution(n,arr,c));
    }
}

/**
 * 참고할 만한 사항.
 * 1. 이진탐색을 활용해서 해결.
 *
 *
 */