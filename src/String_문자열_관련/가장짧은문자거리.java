package String_문자열_관련;

import java.util.Scanner;

/**
 * 문자열과 특정 문자를 입력받을 때, 특정 문자와 문자열 내부 각 문자와의 거리를 모두 출력
 */
class Main_10 {

    public int[] solution(String str, char e) {
        int[] answer = new int[str.length()];
        int p=1000;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == e) {
                p=0;
            }
            answer[i]=p;
            p++;
        }
        for(int j=str.length()-1; j>=0; j--) {
            if(str.charAt(j) == e) {
                p=0;
            }
            answer[j] = Math.min(answer[j], p);
            p++;
        }
        return answer;
    }


    public int[] solution2(String str, char e) {
        int[] answer = new int[str.length()];
        int pos = str.indexOf(e);
        for(int i=0; i<str.length(); i++) {
            answer[i] = Math.abs(pos-i);
        }

        int prevPos = pos;

        while((pos = str.indexOf(e,pos+1)) != -1) {
            for(int i=prevPos+1; i<str.length(); i++) {
                answer[i] = Math.min(answer[i], Math.abs(pos-i));
            }
            prevPos = pos;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_10 main = new Main_10();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        char e = sc.next().charAt(0);
        for(int m : main.solution(inputStr, e)) {
            System.out.print(m + " ");
        }
    }
}


/**
 *참고할 만한 사항
 *
 * 1. str.indexOf() 의 인자로는, char 형도 올 수 있고 String 형도 올 수 있다.
 *  - str.indexOf(char형 변수);
 *  - str.indexOf(String형 변수);
 *
 * 2. 문자열(길이1)을 char형으로 바꾸는 방법
 * - str.charAt(0)
 *
 * 3. Math 패키지
 *    -java.lang.Math 패키지
 *
 *
 *
 */