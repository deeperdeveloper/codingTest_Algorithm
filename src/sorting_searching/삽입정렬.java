package sorting_searching;

import java.util.Scanner;

class Main_3 {

    public int[] solution(int n, int[] arr) {
        for(int i=1; i<n; i++) {
            int tmp=arr[i];
            int j;
            for(j=i-1; j>=0; j--) {
                if(tmp < arr[j]) {
                    arr[j+1] = arr[j];
                } else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public int[] solution2(int n, int[] arr){
        for(int i=1; i<n; i++){
            boolean flag = false;
            for(int j=i-1; j>=0; j--) {
                if(arr[j] < arr[i]) {
                    flag = true;
                    int tmp = arr[i];
                    for(int k=0; k<i-j-1; k++) {
                        arr[i-k] = arr[i-k-1];
                    }
                    arr[j+1] = tmp;
                    break;
                }
            }
            if(!flag) {
                int tmp = arr[i];
                for(int k=0; k<i; k++) {
                    arr[i-k] = arr[i-k-1];
                }
                arr[0] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int k : main.solution(n, arr)) {
            System.out.print(k + " ");
        }
    }
}

/**
 * 알아두어야 할 사항
 *
 * 1. solution()은 solution2() 보다 아래의 측면에서 더 우수한 풀이
 *    -j를 for문 바깥으로 뽑아내어서, 맨 앞의 index까지도 처리할 수 있게 한 점.
 *
 *
 *
 * 2. 삽입정렬
 *    - 2번째 원소부터 시작하여, 맨 앞의 원소들이랑 비교하여 자기보다 바로 아래에 작은 원소 바로 오른쪽에 위치
 *    => 즉, 앞에서부터 하나하나 오름차순 정렬한다고 생각하면 됨
 *
 *    - Best의 경우는 O(N)이며, Worst와 Average의 경우 O(N^2)
 *      => Best의 경우는, 오름차순으로 정렬되어 있는 경우
 *          - i번째 원소와 (i-1)번째 원소를 비교만 하고 swap 과정이 일어나지를 않으므로 n-1번만 발생
 *      => Worst의 경우는, 내림차순으로 정렬되어 있는 경우.
 *          - i번째 원소는 항상 1~(i-1)번째 원소와 비교하고, swap 과정까지 일어나야 한다.
 *
 *    2-1. 출처
 *      - https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
 *
 */