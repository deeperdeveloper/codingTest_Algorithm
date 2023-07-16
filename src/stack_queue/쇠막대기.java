package stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 쇠막대기를 큰 소괄호 (    ) 로 입력받고, 그 다음에 레이저는 작은 소괄호 ()로 입력받을 떄,
 * => '('과 ')'로 이루어진 문자열을 입력받을 때, 레이저에 의해 잘려진 쇠막대기 갯수
 */
class Main_5 {

    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char prev = '(';
        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else {
                if(prev == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
            prev = c;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        String parenStr = sc.next();
        System.out.print(main.solution(parenStr));
    }
}
