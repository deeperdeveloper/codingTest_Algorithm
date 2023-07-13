package String_문자열_관련;

import java.util.Scanner;

/**
 * 입력받은 문자열에 대해 아래의 조작을 거친 후, 결과물의 문자열을 출력
 *  - 입력받은 문자열의 각 구성 문자에 대해, 대문자 -> 소문자, 소문자 -> 대문자로 변환
 *
 *  (2가지 풀이 제시)
 */

class Main_2 {

    public String solution1(String str) {
        String answer = "";
        for(char c : str.toCharArray()) {
            if(c>=97 && c<=122) answer += (char)(c-32); //c가 소문자인 경우, 대문자로 변환시켜서 answer에 덧셈 연산
            else answer += (char)(c+32); //c가 대문자인 경우, 소문자로 변환시켜서 answer에 덧셈 연산.
        }
        return answer;
    }

    public String solution2(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++) {
            if(Character.isUpperCase(arr[i])) {
                answer += Character.toLowerCase(arr[i]);
            } else {
                answer += Character.toUpperCase(arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.println(main.solution1(inputStr));
    }
}


/**
 * 풀이 요약 및 참고할 사항
 *
 * 1. 이 문제에서는, char형을 문자형으로 변환하는데 아래의 방법을 사용했다.
 *      - String result = 빈 문자열("") + char형
 *
 *  1-1. 이외에도, 아래의 방법으로 가능하다.
 *      - String result = String.valueOf(char형 변수) + String.valueOf(char형 변수)
 *      - String result = Character.toString(char형 변수) + Character.toString(char형 변수);
 *
 *  1-2. 출처
 *      - https://kang-james.tistory.com/entry/JAVA-%ED%8C%8C%ED%97%A4%EC%B9%98%EA%B8%B0-%EB%AC%B8%EC%9E%90-%ED%83%80%EC%9E%85-char-%EC%99%80-%EB%AC%B8%EC%9E%90%EC%97%B4-String-%EC%9D%98-%EC%A7%84%EC%8B%A4
 *
 * ============================================================================================================
 *
 * 2. 문자가 대문자인지, 소문자인지 판별하는 메서드
 *      - boolean result = Character.isUpperCase(c); (c는 char형 타입)
 *      - boolean result = Character.isLowerCase(c); (c는 char형 타입)
 *
 * ============================================================================================================
 *
 * 3. 이 문제에서는, 아스키 코드 표의 숫자 중, 소문자와 대문자가 10진수로 대응시켰을 때, 항상 32 차이가 나는 점을 활용하여 해결.
 *
 *  3-1. 대문자(A~Z)는 65~90, 소문자(a~z)는 97~122에 대응된다.
 *
 *  3-2. 출처
 *      - https://log-laboratory.tistory.com/207
 *
 */