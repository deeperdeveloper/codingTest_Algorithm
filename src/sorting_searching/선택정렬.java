package sorting_searching;

import java.util.Scanner;
/**
 * n개의 자연수(1~100)를 입력받을 때, 오름차순으로 정렬하여 출력 (선택정렬)
 */
class Main_1 {

    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n; i++) {
            int idx = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            //arr[idx]가 제일 최소이므로, arr[i]와 교체 작업
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int k : main.solution(n,arr)) {
            System.out.print(k + " ");
        }
    }
}

/**
 * 추가로 알아둘 사항.
 * 1. 선택정렬
 *    - 배열 중, 앞에서부터 순차적으로 돌면서 아래의 사항을 시행
 *      - i번째 원소에 대해, i+1번째부터 마지막 원소 중 가장 최소의 원소(idx번째)를 선택 ((n-1) + (n-2) + .... +1 번 시행)
 *      - i번째 원소와 idx번째 원소를 swap (3 * (n-1) 번 시행)
 *      - i == n-1 까지 위의 사항을 반복
 *
 *    1-1. 시간복잡도
 *      - 최악, 최고, 평균 시간복잡도 모두 O(n^2)이다. (왜냐하면, 최소의 원소를 선택하는 과정은 모두 동일하므로)
 *
 *    1-2. 출처
 *      - https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
 *
 *
 */