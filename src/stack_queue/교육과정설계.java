package stack_queue;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 선수과목을 입력받고, 수강계획과목을 입력받자.
 * => 수강계획 과목내에서 선수과목 순서대로 짜져있으면 YES를 출력하고, 그렇지 않으면 NO를 출력하기
 * 예) ABC / ADEBWQCO => "YES"
 */

class Main_7 {

    public String solution(String needed, String planned){
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char p : planned.toCharArray()) q.offer(p);
        for(char n : needed.toCharArray()) {
            if(!q.contains(n)) return "NO";
            else {
                while(!(q.poll() == n));
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_7 main = new Main_7();
        Scanner sc = new Scanner(System.in);
        String needed = sc.nextLine();
        String planed = sc.nextLine();
        System.out.print(main.solution(needed, planed));
    }
}

/**
 * 참고할 만한 사항
 * 1. Queue 주요 메서드
 *    - q.contains(Element e) => e를 포함하고 있다면 true 반환 (시간복잡도는 O(n)으로 예상됨. 첫번째 노드부터 순서대로 탐색하기 때문)
 *
 *
 */