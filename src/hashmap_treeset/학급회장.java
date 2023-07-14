package hashmap_treeset;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * N명의 학생이 A~E 후보 중 하나를 투표하여 반장 선출
 */

class Main_1 {

    public char solution(int n, String str) {
        char answer = ' ';
        int cnt = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char t : str.toCharArray()) {
            map.put(t, map.getOrDefault(t,0)+1);
        }

        for(char e : map.keySet()) {
            if(cnt < map.get(e)) {
                answer = e;
                cnt = map.get(e);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String voteResult = sc.next();
        System.out.print(main.solution(n, voteResult));
    }
}

/**
 * 알아두어야 할 사항
 * 1. HashMap
 *    - 중복이 많은 데이터들을 효과적으로 분류하는데 사용하면 좋겠다는 생각이 듦.
 *
 *
 *    1-1. 시험 때 필요한 메서드
 *      - map.getOrDefault(key값, value기본값);
 *      - map.keySet();
 *      -
 */
