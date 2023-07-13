package String_문자열_관련;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * N을 입력받고, N개의 단어를 줄 단위로 입력받은 다음, 각 단어를 뒤집어서 줄 단위로 출력
 *
 * 2가지 풀이
 * (StringBuilder 활용)
 */
class Main_4 {

    public ArrayList<String> solution(ArrayList<String> arr) {
        ArrayList<String> answer = new ArrayList<>();

        for(String str : arr) {
            String tmp = new StringBuilder(str).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public ArrayList<String> solution2(ArrayList<String> arr) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<arr.size(); i++) {
            char[] strCompArr = arr.get(i).toCharArray();
            int lt = 0;
            int rt = strCompArr.length-1;
            while(lt < rt) {
                char tmp = strCompArr[rt];
                strCompArr[rt] = strCompArr[lt];
                strCompArr[lt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(strCompArr));
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main_4 main = new Main_4();
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String inputStr = sc.next(); //sc.nextLine()으로 받으면, 마지막 줄의 단어가 씹힌다.
            arr.add(inputStr);
        }
        for(String outputStr : main.solution(arr)) {
            System.out.println(outputStr);
        }
    }

    /**
     * 참고할 만한 사항.
     *
     *
     * 1. String vs StringBuilder vs StringBuffer
     *  - 우선, 문자열 연산(+)는 아래의 메커니즘으로 진행된다.
     *     => String result = "a" + "b"; 수행 시,
     *     => 컴파일 전 내부적으로 StringBuilder 클래스를 활용하여 아래와 같이 진행한다.
     *     => String result = new StringBuilder("a").append("b").toString();
     *
     *     => 따라서, 문자열 연산이 빈번할수록 StringBuilder() 객체가 쓸데없이 많이 생성될 것이다.
     *     => 문자열 연산이 빈번할 때는, StringBuilder() 객체를 미리 생성해두고 append() 메서드를 활용하는 것을 추천.
     *
     *     1-1. StringBuilder와 StringBuffer의 차이는, 멀티 스레드에 대해 safe한지 안한지의 차이이다.
     *     => 따라서, 일반적인 연산의 경우, StringBuilder가 StringBuffer보다 성능이 "미세하게" 우수하다고 한다.
     *
     *
     *     1-2. 출처
     *     https://inpa.tistory.com/entry/JAVA-%E2%98%95-String-StringBuffer-StringBuilder-%EC%B0%A8%EC%9D%B4%EC%A0%90-%EC%84%B1%EB%8A%A5-%EB%B9%84%EA%B5%90
     *     (블로그 자체가 괜찮음)
     *
     * 2. 문자배열 -> 문자열로 합칠 때 쓰는 메섣,
     *      - String result = String.valueOf(char[] arr)
     *
     */
}