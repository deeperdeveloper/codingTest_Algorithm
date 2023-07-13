package String_문자열_관련;

import java.util.Scanner;

/**
 * 문자열을 입력받을 때, 문자열을 이루는 숫자를 순서대로 추출하여 이어붙인 자연수를 출력
 */
class Main_9 {

    public int solution(String str) {
        int answer = 0;
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) answer = answer*10 + (c-48);
        }
        return answer;
    }

    public int solution2(String str) {
        str = str.replaceAll("[^0-9]","");
        int answer = Integer.parseInt(str);
        return answer;
    }

    public static void main(String[] args){
        Main_9 main = new Main_9();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.println(main.solution(inputStr));
    }
}

/**
 * 참고할 만한 사항
 * 1. char 타입의 변수가 "숫자"인지 확인하는 방법
 *  - Character.isDigit(char 타입 변수)
 *
 *
 *
 */