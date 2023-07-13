package String_문자열_관련;

import java.util.Scanner;

/**
 * 영어로 주어진 문장에서, 가장 긴 길이의 단어 출력
 */
class Main_3 {

    public String solution(String str) {
        String answer = "";
        Integer m = Integer.MIN_VALUE;
        String[] arr = str.split(" ");
        for(int i=0; i<arr.length; i++) {
            if(m < arr[i].length()) {
                m = arr[i].length();
                answer = arr[i];
            }
        }
        return answer;
    }

    public String solution2(String str) {
        String answer = "";
        int pos = 0; //부분문자열 중, " "가 위치하는 인자의 위치
        int subStrLength = Integer.MIN_VALUE;

        while(str.indexOf(" ")!=-1) {
            pos = str.indexOf(" ");
            //부분문자열의 길이(pos-0)가 이 때까지의 가장 긴 부분문자열의 길이(subStrLength) 보다 긴 경우
            if(pos > subStrLength) {
                answer = str.substring(0,pos);
                subStrLength = pos;
            }
            //while문으로 회귀할 경우, 조사한 부분문자열을 제외한 나머지 문자열을 str에 할당함.
            str = str.substring(pos+1);
        }

        //문자열의 마지막 단어에 대해 조사
        if(str.length() > subStrLength) {
            answer = str;
        }
        return answer;
    }

    //아래의 풀이는 시간 초과가 뜸.

/*    public String solution(String str) {
        String answer = "";
        int tmp = 0; //부분문자열 맨 첫번째 인자.
        int pos = 0; //부분문자열 중, " "가 위치하는 인자의 위치
        int subStrLength = Integer.MIN_VALUE;
        while(str.indexOf(" ")!=-1) {
            pos = str.indexOf(" ");
            if(pos-tmp>subStrLength) {
                answer = str.substring(tmp,pos);
                subStrLength = pos-tmp;
            }
            tmp = pos+1;
        }

        //문자열의 마지막 단어에 대해 조사
        if(str.substring(tmp).length() > subStrLength) {
            answer = str.substring(tmp);
        }
        return answer;
    }*/



    public static void main(String[] args) {
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        System.out.print(main.solution(inputStr));
    }

}

/**
 * 참고할 만한 사항
 *
 * 1. sc.next() vs sc.nextLine()
 *  - 개행문자를 포함하냐, 포함하지 않냐의 차이.
 *  예) adswweq(엔터)bqqq 치면
 *      String a = sc.next();  //adswweq\n
 *      //위 코드에 이어서 아래 코드 삽입
 *      String b = sc.nextLine(); // \t (빈줄로 끝남)
 *
 *  출처 : https://velog.io/@suyyeon/JAVA-Scanner%ED%81%B4%EB%9E%98%EC%8A%A4-next-nextLine-%EC%B0%A8%EC%9D%B4
 *
 * =========================================================================
 *
 * 2. str.indexOf(subStr) 메서드
 *  - str 문자열 내부에서, subStr 부분 문자열이 가장 먼저 나타나는 index를 반환
 * 
 * 
 * 
 * 3. str.substring() 메서드
 *      - str.substring(beginIndex, endIndex);
 *      - str.substring(beginIndex);
 *
 *      -- subString() 이 아니라 substring()임에 주목
 *      
 */