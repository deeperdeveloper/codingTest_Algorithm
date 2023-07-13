package String_문자열_관련;

import java.util.Scanner;

/**
 * 문자열과 특정 문자를 입력받은 후, 특정 문자가 문자열에 몇 개 있는지 출력. (대소문자 구분 없음)
 */
class Main_1 {

    public int solution(String str, String findStr) {
        int count = 0;
        char[] arr = str.toUpperCase().toCharArray();
        char t = findStr.toUpperCase().charAt(0);
        for(char c : arr) {
            if(c == t) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        String findStr = sc.next();
        System.out.print(main.solution(inputStr, findStr));
    }

    /**
     * 참고할 만한 사항
     *
     * 1. 문자열을 통째로 대문자로(혹은 소문자로) 바꾸는 메서드
     *  - String result = str.toUpperCase();
     *  - String result = str.toLowerCase();
     *
     * 2. 문자열 중 특정 i번째 문자를 알아내는 메서드
     *  - char c = str.charAt(i);
     *
     * 3. 문자열 -> 문자 배열(문자열을 이루는 각 문자가 요소)
     *  - char[] arr = str.toCharArray();
     *
     */
}