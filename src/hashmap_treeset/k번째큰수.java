package hashmap_treeset;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

/**
 * 1~100 사이의 자연수를 n개 입력받을 때, 3개 뽑아서 가능한 합들 중 k번째로 큰 수 구하기
 */

class Main_5 {

    public int solution(int n, int k, int[] arr){
        int answer = -1;
        Set<Integer> sums = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int p=j+1; p<n; p++) {
                    sums.add(arr[i] + arr[j] + arr[p]);
                }
            }
        }
        //sums에서 k번째로 큰 수 찾기
        int cnt = 1;
        for(int x : sums) {
            if(cnt == k) return x;
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print(main.solution(n,k,arr));
    }
}


/**
 * 추가적으로 정리할 사항
 *
 * 1. TreeSet은 이진 검색 트리로 구현되어 있음.
 *    -
 *
 * 2. TreeSet을 for문으로 돌릴 수 있다는 거는, iterator()를 구현했다는 것으로 이해함.
 *    => 실제로 debugging point를 실행구문의 for문과 TreeSet 클래스의 iterator()에 걸면, 그렇다는 것을 알 수 있다.
 *    => 해당 breakPoint를 계속 따라가다 보면, 결국 정렬된 첫번째 원소를 반환함을 알 수 있다.
 *    (이 부분 정리할 것)
 *
 *
 * 3. TreeSet은 add() 할 때, 정렬되어서 추가됨을 알 수 있다. (내부 코드를 뜯어봤을 때 알 수 있다)
 *
 *
 * 4. TreeSet 주요 메서드
 *    - treeSet.add(element);
 *    - treeSet.remove(element);
 *    - treeSet.contains(element);
 *    - treeSet.size();
 *
 *
 * 5. TreeSet에서 주요 메서드에 대한 시간복잡도 파악하기
 *    - treeSet.add(), treeSet.remove() 모두 시간복잡도가 O(log N) 이다.
 *      => (조금 더 정리) 깊이 탐색을 하기 때문에 저렇다는 거는 충분히 예측 가능하다.
 *
 */
