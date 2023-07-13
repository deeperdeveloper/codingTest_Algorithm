package String_문자열_관련;

import java.util.Scanner;
/**
 * 문자열을 거꾸로 읽을 때, 같은 문자열이면 YES 출력 (대소문자 구분 없음)
 */
class Main_7 {

    public String solution(String str) {
        String answer = "NO";
        String reverseStr = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reverseStr)) answer = "YES";
        return answer;
    }

    public String solution2(String str) {
        str = str.toUpperCase();
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-1-i)) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args){
        Main_7 main = new Main_7();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.print(main.solution(inputStr));
    }
}

/**
 * 참고할 만한 사항
 * 1. str.equalsIgnoreCase(str 타입 변수) 로 대소문자를 무시하고 논리적으로 같은지(equals) 확인한다.
 *  - 근데 별로 쓰일 일은 없을 듯..
 */
