package sorting_searching;

import java.util.Scanner;
import java.util.Arrays;

/**
 * n개의 숫자를 입력받고 오름차순 정렬 후, 이 중 m의 위치를 찾기 (이분검색 활용)
 */
class Main_8 {

    public int solution(int n, int[] arr, int m){
        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;
        int mt = 0;
        while(lt < rt) {
            mt = (lt+rt)/2;
            if(arr[mt] == m) return mt+1;
            else if(arr[mt] > m) rt = mt;
            else lt = mt;
        }
        return mt+1;
    }

    public static void main(String[] args){
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = sc.nextInt();

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print(main.solution(n,arr,m));
    }
}
