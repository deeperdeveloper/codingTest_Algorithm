package sorting_searching;

import java.util.Scanner;

/**
 * n개의 자연수(1~100)를 입력받을 때, 오름차순으로 정렬하여 출력 (버블정렬)
 */
class Main_2 {

    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public int[] solution2(int n, int[] arr){
        int j=n-1;
        while(j!=0) {
            for(int i=0; i<j; i++) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
            j--;
        }
        return arr;
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int k : main.solution(n,arr)) {
            System.out.print(k+ " ");
        }
    }
}


/**
 *  추가로 알아둘 사항.
 *
 *  1. 버블정렬
 *      - 순차적으로 최댓값을 정해나가는 정렬
 *      - 인접한 두 원소끼리(arr[i], arr[i+1]) 비교하여, 큰 값을 오른쪽에 배치
 *      => 버블정렬이 한 차례 시행(i==n-2 까지)되고 나면, 맨 마지막 원소는 최댓값이 보장된다.
 *
 *      - 이제, i=0 에서 i==n-1까지 위의 과정을 반복하자 (따라서, 이 때 모든 경우에 대해 (n-1) + (n-2) + ... + 1 번 시행되어야 한다)
 *      => 버블정렬에 의해, 배열은 오름차순으로 정렬된다.
 *
 *      1-1. 시간복잡도
 *      - 최고, 최악, 평균 모두 O(n^2)이다.
 *
 *      1-2. 출처
 *          - https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
 */
