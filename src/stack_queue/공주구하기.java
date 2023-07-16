package stack_queue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1~N번의 번호를 가진 왕자 N명 중, (K의 배수의 집합) % N 에 해당하지 않는 왕자 출력
 */

class Main_6 {

    public int solution(int n, int k){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.offer(i);

        int cnt = 1;
        while(q.size() != 1) {
            if(cnt % k != 0) q.offer(q.poll());
            else q.poll();
            cnt++;
        }
        answer = q.poll();
        return answer;
    }

    public int solution2(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.offer(i);
        while(!q.isEmpty()) {
            for(int i=1; i<k; i++) q.offer(q.poll()); //(k-1)번 실행
            q.poll();
            if(q.size() == 1) answer = q.poll();
        }
        return answer;
    }

    public static void main(String[] args){
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.print(main.solution(n,k));
    }
}

/**
 * 참고할 만한 사항
 *
 * 1. solution2() 의 풀이를 solution1()과 비교하면서 읽기
 *
 * 2. Queue의 주요 메서드
 *    - q.offer(Element e); (O(1)) //맨 마지막 노드를 가리키는 pointer가 있기 때문에, O(1)이 가능함.
 *    - q.poll(Element e);  (O(1))
 *    - q.size();           (O(1))
 *    - q.isEmpty();        (O(1))
 *
 *    2-1. (생각해 볼 사안)
 *    - 분명 Queue는 인터페이스고, 그것의 구현체는 LinkedList 임에도, size()와 isEmpty()는 AbstractCollection에 구현되어 있는 것을 활용한다.
 *      => 이유를 파악해보기. 상속 관계 등을 다시 눈 여겨볼것
 *
 */