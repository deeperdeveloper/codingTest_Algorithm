package String_문자열_관련;

import java.util.Scanner;

/**
 * 암호를 구성하는 문자의 갯수와  #,*로 이루어진 암호를 입력받을 때, 암호를 영문자로 해독하여 출력하기.
 * - #은 1로, *는 0으로 변환된다는 규칙 적용
 * 
 */
class Main_12 {

    public String solution(int n, String str) {
        String answer = "";
        str = str.replace("#","1").replace("*","0");
        for(int i=0; i<n; i++) {
            char subPassword = (char) Integer.parseInt(str.substring(0,7),2);
            answer += subPassword;
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args){
        Main_12 main = new Main_12();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String inputStr = sc.nextLine();
        System.out.println(main.solution(n, inputStr));
    }
}

/**
 * 참고할 만한 사항
 *
 * 1. 문자열을, 2진법으로 읽어 10진법의 정수로 변환하는 방법
 *  - Integer.parseInt("1001",2) 의 결과는 9이다.
 *
 * 2. 문자열 내부의 특정 문자를 다른 문자로 바꾸는 방법
 *  - str.replace("#","1")
 *
 *
 */