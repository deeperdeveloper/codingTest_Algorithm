package hashmap_treeset;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main_4 {

    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x,0) + 1); //b에 대한 정보 입력
        int len = b.length() - 1; //-1을 추가한 이유는 아래의 for문 때문이다.

        for (int i=0; i<len; i++)
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1); //a에서, 0~b.length()-2번째까지의 정보를 am에 입력
        int lt = 0;
        for(int rt=len; rt<a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt),0) + 1);
            if(am.equals(bm)) answer++; //am과 bm의 mapping이 모두 같으면, if문의 조건문은 true를 반환
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }

    public int solution2(String targetStr, String str) {
        int answer = 0;
        int lenOfTarget = targetStr.length();
        int lenOfStr = str.length();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        for(int i=0; i<lenOfStr; i++) {
            map.put(targetStr.charAt(i), map.getOrDefault(targetStr.charAt(i),0)-1);
            if(map.get(targetStr.charAt(i))==0) map.remove(targetStr.charAt(i));
        }
        if(map.size() == 0) answer++;

        for(int j=lenOfStr; j<lenOfTarget; j++) {
            map.put(targetStr.charAt(j-lenOfStr), map.getOrDefault(targetStr.charAt(j-lenOfStr),0)+1);
            map.put(targetStr.charAt(j), map.getOrDefault(targetStr.charAt(j),0)-1);
            if(map.get(targetStr.charAt(j-lenOfStr))==0) map.remove(targetStr.charAt(j-lenOfStr));
            if(map.containsKey(targetStr.charAt(j)) && map.get(targetStr.charAt(j)) == 0) map.remove(targetStr.charAt(j));
            if(map.size() == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        String targetStr = sc.nextLine();
        String str = sc.nextLine();
        System.out.print(main.solution(targetStr, str));
    }
}

/**
 * 참고할 만한 사항
 * 1. HashMap method
 *      - am.equals(bm)
 *        => map의 mapping이 모두 같다면(순서 상관없음), true를 반환
 *
 *
 * 2. solution() 과 solution2()는 큰 맥락에서는 풀이가 같다.
 *      - 그러나, solution()은 아래의 측면에서 훨씬 깔끔하다.
 *         (1) lt, rt를 사용하여 변수의 의미를 명확히 함.
 *         (2) for문 처리할 때, answer++를 한번만 사용하게끔 하기 위해, len = b.length()가 아닌 len = b.length() -1로 둔 점.
 *              (2)-1. 여기서, for문 한바퀴 시작과 끝에서 어떤 변화가 있었는지 상상하면서 코드를 작성하면, 좀 더 명확해질 것으로 생각함.
 *
 *
 */