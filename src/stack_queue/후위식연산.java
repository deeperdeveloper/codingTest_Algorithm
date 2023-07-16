package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문자열로 후위연산식을 입력받을 때, 연산 결과 출력
 * 예) 147+*2- 는, 1*(4+7)-2 와 같다.
 */

class Main_4 {

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) stack.push(c-48);
            else {
                int b = stack.pop();
                int a = stack.pop();
                if(c == '+') stack.push(a+b);
                else if(c == '*') stack.push(a*b);
                else if(c == '-') stack.push(a-b);
                else if(c == '/') stack.push(a/b);
            }
        }
        answer = stack.pop();
        return answer;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(main.solution(str));
    }
}

/**
 *
 * 참고할 만한 사항
 *
 * 1. stack.pop()도 있고, stack.get(int index) 도 있음.
 *
 *
 */