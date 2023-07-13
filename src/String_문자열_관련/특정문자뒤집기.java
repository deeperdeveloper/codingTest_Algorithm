package String_문자열_관련;

import java.util.Scanner;

/**
 * 입력받은 문자열을 구성하는 요소 중, 알파벳만 뒤집어서, 문자열 재구성하여 출력
 */
class Main_5 {

    public String solution(String str) {
        String answer;
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = chars.length-1;
        while(lt<rt) {
            if(!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if(!Character.isAlphabetic(chars[rt])) { //chars[lt]는 alphabet 임이 확정됨.
                rt--;
            } else { //chars[lt]와 chars[rt]가 모두 alphabet 일 때.
                char tmp = chars[rt];
                chars[rt] = chars[lt];
                chars[lt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(chars);
        return answer;
    }


    public String solution2(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        int lt = 0;
        int rt = arr.length - 1;
        while(lt<rt) {
            while(!Character.isAlphabetic(arr[lt])) {
                lt++;
            }
            while(!Character.isAlphabetic(arr[rt])) {
                rt--;
            }
            if(lt>=rt) {
                break;
            }
            char tmp = arr[rt];
            arr[rt] = arr[lt];
            arr[lt] = tmp;
            lt++;
            rt--;
        }
        answer = String.valueOf(arr);
        return answer;
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.println(main.solution(inputStr));
    }
}

/**
 * 참고할 만한 사항
 * 
 * 1. Character.isAlphabetic(char c) => c가 알파벳이면 true,그렇지 않으면 false를 반환
 * 
 * 
 */
