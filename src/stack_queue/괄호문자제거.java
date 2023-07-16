package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문자열을 입력받을 떄, ()안의 문자열을 제거하고 나머지 문자열을 출력하기
 */

class Main_2 {

    public String solution(String str){
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else if(c == ')') stack.pop();
            else {
                if(stack.isEmpty()) builder.append(c);
            }
        }
        return builder.toString();
    }

    public String solution2(String str) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            //소괄호 제거 로직
            if (c == ')') {
                while (stack.pop() != '(') ; // '('가 나올 때까지 stack의 원소를 모두 제거
            } else {
                stack.push(c);
            }
        }
        //이제 해당 stack 내부에는, ()안의 문자열이 모두 제거되고 난 이후의 나머지 문자열이 남아있음.
        for(int i=0; i<stack.size(); i++) {
            builder.append(stack.get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.next();
        System.out.print(main.solution(inputStr));
    }
}

/**
 * 생각해 볼 사안
 *  1. solution2() 방식 기억해두기.
 *      - solution() 에 비해서, ()내부 문자열을 "코드의 관점에서" 제거하는 로직이라고 생각함
 *  2. stack 메서드
 *     - stack.get(int index); 활용 가능
 *     -
 *
 */