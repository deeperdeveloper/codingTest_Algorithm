package String_문자열_관련;

import java.util.Scanner;

/**
 * 문자열을 입력받을 때, 문자열을 이루는 문자 중 알파벳(대소문자 구분x)을 거꾸로 읽어도 같은지 여부를 판별
 */
class Main_8 {

    public String solution(String str) {
        String answer = "NO";
        String replacedStr = str.replaceAll("[^a-zA-Z]","").toUpperCase();
        String reversedReplacedStr = new StringBuilder(replacedStr).reverse().toString();

        if(replacedStr.equals(reversedReplacedStr)) answer = "YES";
        return answer;
    }

    //replaceAll() 안 쓰는 풀이법
    public String solution2(String input) {
        String answer = "NO";
        StringBuilder saveStringBuilder = new StringBuilder();

        //input 문자열 중 문자에 해당하는 부분만 saveStringBuilder 객체에 저장
        for(int i=0; i<input.length(); i++) {
            if(Character.isAlphabetic(input.charAt(i))) {
                saveStringBuilder.append(input.charAt(i));
            }
        }

        //saveStringBuilder 객체에 저장된 문자열 추출
        String saveString = saveStringBuilder.toString();

        //saveStringBuilder 객체에 저장된 문자열을 거꾸로 추출하여 저장
        String reverseSaveString = saveStringBuilder.reverse().toString();

        if(reverseSaveString.equalsIgnoreCase(saveString)) {
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args){
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        System.out.print(main.solution(inputStr));
    }
}

/**
 * 참고할 만한 사항
 * 1. str.replaceAll(정규식, 바꾸고자 하는 문자열);
 *    - String replacedStr = str.replaceAll("[^a-zA-Z]", "");
 *      => 알파벳을 제외한 모든 문자에 대해, "" 처리(즉, 없는 것으로 처리)
 *
 *    - 더 많은 사용 선례
 *      출처 : https://jamesdreaming.tistory.com/85
 *
 *
 */