package twopointers_slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 두 개의 집합을 입력받을 때, 공통원소들을 오름차순으로 출력하기
 */

class Main_2 {

    public ArrayList<Integer> solution(int a, int[] arrA, int b, int[] arrB) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int pt1 = 0;
        int pt2 = 0;

        while(pt1 != a && pt2 != b) {
            if(arrA[pt1] > arrB[pt2]) pt2++;
            else if(arrA[pt1] < arrB[pt2]) pt1++;
            else {
                answer.add(arrA[pt1++]);
                pt2++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] arrA = new int[a];
        for(int i=0; i<a; i++) {
            arrA[i] = sc.nextInt();
        }

        int b = sc.nextInt();
        int[] arrB = new int[b];
        for(int j=0; j<b; j++) {
            arrB[j] = sc.nextInt();
        }

        for(int k : main.solution(a,arrA,b,arrB)) {
            System.out.print(k + " ");
        }
    }
}

/**
 * 생각해 볼 사안
 * 1. Arrays.sort()
 *  - 배열을 정렬할 때 사용된다.
 *  
 *      1-1. 시간복잡도
 *        - 1-3 참조
 *      
 *      1-2. 
 *        - 
 *        
 *        
 *      1-3. 아래의 사이트에 근거하여 반드시 더 깊게 파 볼 것
 *          - 퀵 정렬의 원리
 *            => 첫번째 원소를 pivot으로 삼아서 진행한다.
 *            => 평균적으로 O(N log N)이며, 최악의 경우 O(N^2)이다.
 *              - 최악의 경우는, 원소가 완벽하게 오름/내림 차순으로 정렬되어 있어서 분할 정복이 발생하지 않는 경우이다.
 *          - https://blog.naver.com/ndb796/221226813382
 *          - https://zeddios.tistory.com/35
 *          - https://velog.io/@haero_kim/%EC%A0%95%EB%A0%AC-%EC%84%B8%EA%B3%84%EA%B4%80-%EC%B5%9C%EA%B0%95%EC%9E%90-Quick-Sort
 *
 *      1-4. 조사할 때, Collections.sort() 와의 차이를 비교해보기.
 *          - Collections.sort()는 평균/최악의 경우가 모두 O(N log N) 이다.
 *          - 지역성의 원리까지 고려해볼것.
 *          - https://d2.naver.com/helloworld/0315536
 *          - https://laugh4mile.tistory.com/175
 *
 *
 *
 */