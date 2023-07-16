package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * '(' 과 ')'로 이루어진 문자열에 대해, ()쌍을 완벽하게 이루면 "YES" 반환
 */

class Main_1 {

    public String solution(String paranStr){
        Stack<Character> stack = new Stack<>();
        for(char c : paranStr.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.size() == 0) return "NO";
                stack.pop();
            }
        }
        if(stack.size() > 0) return "NO";

        return "YES";
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        String paranStr = sc.next();
        System.out.print(main.solution(paranStr));
    }
}


/**
 * 생각해 볼 사안
 *
 * 1. Stack
 *
 *    1-1. Vector를 상속받은 자료구조
 *          -Vector는 "동기화가 보장된" ArrayList라고 생각하기 (일단은)
 *          -(아래에서 후술하겠지만, Stack보다 훨씬 성능 좋고 의미있는
 *
 *    1-2. 후입선출의 자료구조
 *
 *    1-3. 주요 메서드
 *      - E e = stack.push(E e); //stack 맨 상단에 e를 집어넣음
 *      - E e = stack.pop();
 *      - E e = stack.peek();
 *      - int i = stack.search(E e);
 *      - boolean result = stack.isEmpty();
 *      - boolean result = stack.remove(E e);
 *      - boolean result = stack.remove(int index);
 *      - int index = stack.search(E e);
 *         - 삽입(push)/삭제(pop)/읽기(peek)는 모두 O(1)
 *         - 탐색(search)는 O(n)
 *
 *   1-4. Stack의 한계점과 대안
 *      - 아래의 큰 3가지 단점이 있다.
 *          1) 동기화 메소드가 많기 때문에, 단일 스레드 환경에서 성능이 떨어진다.
 *          2) LIFO 구조를 의도하였지만, 사실상 Vector의 자료구조를 활용하기에 중간에 데이터 삽입/삭제가 가능하다.
 *          3) 초기 용량 설정 불가능으로 인해, 많은 데이터를 삽입 시 내부적으로 배열 복사가 비넙ㄴ하게 일어난다.
 *
 *      - 대안 및 추가로 공부해야 할 사항
 *          - Deque 인터페이스를 구현한 ArrayDeque를 활용하자.
 *          - ArrayDeque는 queue, stack 모두 다 활용할 수 있다. (이 부분 자세히 공부해서 남기기)
 *          - ArrayDeque는
 *      - 출처
 *          - https://devlog-wjdrbs96.tistory.com/244 (stack 대신 arraydeque 를 활용하라는 문구)
 *          - https://github.com/wjdrbs96/Today-I-Learn/blob/master/Java/Collection/Queue/ArrayDeque%EB%9E%80%3F.md
 *          - https://steady-coding.tistory.com/357
 *          - https://st-lab.tistory.com/185
 *          - https://hbase.tistory.com/128
 *          
 *
 */