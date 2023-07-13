package String_문자열_관련;

import java.util.Scanner;

/**
 * 알파벳 대문자로만 이루어진 문자열을 입력받을 때, 연속하는 부분문자열은 아래의 형식으로 모두 바꾼 작업을 거친 문자열을 출력
 * - KKK -> K3 으로 변환
 */
class Main_11 {

    public String solution(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        int len = str.length();
        char[] chars = str.toCharArray();

        //문자열 중, 맨 마지막 문자 제외하고
        for(int i=0; i<len-1; i++) {
            if(chars[i] == chars[i+1]) count++;
            else {
                builder.append(chars[i]);
                if(count != 1) {
                    builder.append(count); //되는지 확인
                    count = 1;
                }
            }
        }

        //문자열 중 맨 마지막 문자 추가
        builder.append(chars[len-1]);
        if(count>1) {
            builder.append(count);
        }

        return builder.toString();
    }

    public String solution2(String str) {
        StringBuilder builder = new StringBuilder();
        str = str + " "; // trick
        char[] chars = str.toCharArray();
        int count = 1;
        for(int i=0; i< str.length()-1; i++) {
            if(chars[i] == chars[i+1]) count++;
            else {
                builder.append(chars[i]);
                if(count != 1) {
                    builder.append(count); //되는지 확인
                    count = 1;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Main_11 main = new Main_11();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.print(main.solution(inputStr));
    }
}

/**
 * 참고할 만한 사항
 * 1. solution2() 에서, for문의 index 때문에 Str의 맨 끝에 공백(" ")을 추가한 점에 주목하자.
 *
 */