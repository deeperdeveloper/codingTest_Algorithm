package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main_4 {

    public int solution(int n, ArrayList<Lecture> arr){
        int answer = 0;
        Collections.sort(arr);
        int maxDate = arr.get(0).due;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j=0;
        for(int i=maxDate; i>=1; i--) {
            for(; j<n; j++) {
                if(arr.get(j).due != i) break;
                else pq.offer(arr.get(j).fee);
            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int fee = sc.nextInt();
            int due = sc.nextInt();
            arr.add(new Lecture(fee,due));
        }
        System.out.print(main.solution(n,arr));
    }
}
class Lecture implements Comparable<Lecture> {
    int fee;
    int due;

    Lecture(int fee, int due) {
        this.fee = fee;
        this.due = due;
    }

    @Override
    public int compareTo(Lecture lc){
        if(this.due == lc.due) return -(this.fee - lc.fee);
        else return -(this.due - lc.due);
    }
}

/**
 * 생각해 볼 사안
 * 1. 풀이과정에서, 아래의 2가지 풀이도 고안함 (1가지 풀이는 맞으나 시간초과, 1가지 풀이는 의도를 잘못 이해하여 틀린 풀이)
 *
 * 2. 우선순위 큐
 *    - 여러가지 자료 구조(list, array, heap 등)으로 구현 가능하나, 주로 최소 힙 또는 최대 힙으로 구현한다
 *
 *      2-1. 제일 중요시 되는 부분은, 루트 노드가 가장 작은 값/가장 큰 값을 가지냐이다.
 *          - 노드의 좌측 노드, 우측 노드의 대소 관계는 신경쓰지 않는다.
 *          (해당 부분까지 신경 쓰려면, 이는 "이진 탐색 트리" 라는 용어를 써야 한다.) - 출처 참고
 *
 *      2-2. 주요한 과정은 아래와 같다.
 *         - 삽입 : O(log N)
 *           => 자세히 말하자면, 힙 구조에 1개의 원소를 삽입할 떄 최악의 경우가 O(log N)이다.
 *
 *         - 삭제 : O(log N)
 *           => 동일
 *
 *         - 정렬 : O(N log N)
 *           => N개의 원소를 한번에 힙 구조에 삽입하는 경우의 시간복잡도 이다.
 *
 *      2-3. 출처
 *      - https://hoehen-flug.tistory.com/17
 *
 * 3. 용어
 *    - 이진트리, 완전 이진 트리, 전 이진 트리, 포화 이진 트리, 이진 탐색 트리
 *
 *    3-1. 출처
 *    - https://code-lab1.tistory.com/8
 *
 */


/**
 * 아래의 풀이는 정답이기는 하나, 시간 초과가 뜬다.
 * => PriorityQueue에서, 동일한 원소에 대해서 정렬을 너무 많이 시행하기 때문.
 *
 * import java.util.PriorityQueue;
 * import java.util.Scanner;
 *
 * class Main_4 {
 *
 *     public int solution(int n, PriorityQueue<Lecture> pq){
 *         int answer = 0;
 *         while(!pq.isEmpty()){
 *             Lecture cur = pq.poll();
 *             int curLevel = cur.due;
 *             answer += cur.fee;
 *             if(curLevel == 1 || pq.isEmpty()) return answer;
 *             while(pq.peek().due == curLevel) {
 *                 Lecture lc = pq.poll();
 *                 pq.offer(new Lecture(lc.fee, lc.due-1));
 *             }
 *         }
 *         return answer;
 *     }
 *
 *     public static void main(String[] args){
 *         Main_4 main = new Main_4();
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         PriorityQueue<Lecture> pq = new PriorityQueue<>();
 *         for(int i=0; i<n; i++) {
 *             int fee = sc.nextInt();
 *             int due = sc.nextInt();
 *             pq.offer(new Lecture(fee, due));
 *         }
 *         System.out.print(main.solution(n,pq));
 *     }
 * }
 *
 * class Lecture implements Comparable<Lecture> {
 *     int fee;
 *     int due;
 *
 *     Lecture(int fee, int due) {
 *         this.fee = fee;
 *         this.due = due;
 *     }
 *
 *     @Override
 *     public int compareTo(Lecture lc){
 *         if(this.due == lc.due) return -(this.fee - lc.fee);
 *         else return -(this.due - lc.due);
 *     }
 * }
 *
 */


/**
 * 아래의 풀이는 틀린 풀이임
 * - 아주 약간만 틀린 풀이로, 이 풀이는 arr의 갯수 이상의 일수만큼의 lecture에 대해서는 반영하지 못한다.
 *
 * import java.util.ArrayList;
 * import java.util.Collections;
 * import java.util.PriorityQueue;
 * import java.util.Scanner;
 *
 * //이 풀이도 틀린 풀이. 원리는 비슷하나, 이 풀이는 arr의 갯수 이상의 일수만큼의 lecture에 대해서는 반영하지 못한다.
 * class Main_4 {
 *
 *     public int solution(int n, ArrayList<Lecture> arr){
 *         int answer = 0;
 *         Collections.sort(arr);
 *         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
 *         int i=0;
 *         for(; i<n;) {
 *             int tmp = arr.get(i).due;
 *             pq.offer(arr.get(i).fee);
 *             int j;
 *             for(j=i+1; j<n; j++) {
 *                 if(arr.get(j).due != tmp) break;
 *                 else pq.offer(arr.get(j).fee);
 *             }
 *             i=j;
 *             answer += pq.poll();
 *         }
 *         return answer;
 *     }
 *
 *     public static void main(String[] args){
 *         Main_4 main = new Main_4();
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         ArrayList<Lecture> arr = new ArrayList<>();
 *         for(int i=0; i<n; i++) {
 *             int fee = sc.nextInt();
 *             int due = sc.nextInt();
 *             arr.add(new Lecture(fee,due));
 *         }
 *         System.out.print(main.solution(n,arr));
 *     }
 * }
 * class Lecture implements Comparable<Lecture> {
 *     int fee;
 *     int due;
 *
 *     Lecture(int fee, int due) {
 *         this.fee = fee;
 *         this.due = due;
 *     }
 *
 *     @Override
 *     public int compareTo(Lecture lc){
 *         if(this.due == lc.due) return -(this.fee - lc.fee);
 *         else return -(this.due - lc.due);
 *     }
 * }
 *
 *
 *
 */