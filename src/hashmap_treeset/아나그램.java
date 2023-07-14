package hashmap_treeset;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 아나그램 판별
 *  - 아나그램은, 두 문자열을 이루는 알파벳의 종류와 구성 갯수가 모두 일치하는 두 문자열을 일컬음.
 */

class Main_2 {

    //Map을 하나만 만듦.
    public String solution(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str1.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        for(char e : str2.toCharArray()) {
            if(!map.containsKey(e) || map.get(e) == 0) return "NO";
            map.put(e,map.get(e)-1);
        }
        return "YES";
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        String inputStr1 = sc.nextLine();
        String inputStr2 = sc.nextLine();
        System.out.print(main.solution(inputStr1, inputStr2));
    }
}

/**
 * 풀이에 참고할 사항
 * 1. HashMap 메서드
 *    - map.put();
 *    - map.containsKey();
 *
 */
