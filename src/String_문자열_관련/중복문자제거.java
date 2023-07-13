package String_문자열_관련;

import java.util.Scanner;

/**
 * 문자열을 입력받을 때, 중복되는 문자는 제거하면서 문자열을 출력 (이 때, 원래 문자열의 문자 순서는 유지)
 */
class Main_6 {

    public String solution(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(str.indexOf(chars[i]) == i) {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.println(main.solution(inputStr));
    }
}

/**
 * 이 문제의 핵심
 * 1. str.indexOf(char c) 의 의미를 재치있게 파악하는 것이 중요
 *    => str의 구성 문자 중, 가장 먼저 앞쪽에 위치하는 c의 index
 *    => 이를 활용하여 문제를 해결
 *
 *    1-1. 그럼, str.indexOf(char c)의 시간복잡도는?
 *    => O(n)으로 확인된다. (최악의 상황을 가정 시에 그러하며, 내부 코드 또한 for문을 1번 사용함을 확인)
 *
 *
 */