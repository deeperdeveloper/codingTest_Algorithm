package Array_배열;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * N개의 자연수를 입력받을 때, 각 자연수를 뒤집어서 소수가 되면, 뒤집은 수를 모두 출력
 */
class Main_6 {

    public boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i=2; i<num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int tmp = 0;
            while(arr[i] > 0) {
                int res = arr[i] % 10;
                tmp = tmp*10 + res;
                arr[i] = arr[i] / 10;
            }
            if(isPrime(tmp)) answer.add(tmp);
        }
        return answer;
    }


    public ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(new StringBuilder(String.valueOf(arr[i])).reverse().toString());
            int tmp = 0;
            for(int k=2; k<arr[i]; k++) {
                if(arr[i] % k == 0) {
                    tmp = 1;
                    break;
                }
            }
            if(tmp == 0 && arr[i] != 1) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int k : main.solution(n, arr)){
            System.out.print(k+" ");
        }
    }
}

/**
 * 참고할 만한 사항
 * 1. solution2() 로 풀었으나, solution()으로 보강하기.
 *
 *  1-1. 여기서, 소수릂 판별하는 로직을 "별도의 메서드"로 뽑아내었다는 것이 핵심.
 *      - 그리고 해당 로직은 boolean을 활용해서 더 간결해졌다는 점도 주목하기
 *
 *  1-2. int형 수를 뒤집어서 표현하는 방법을 유심히 지켜보기.
 *      - solution2() 에서는, String으로 형 변환 후 reverse()를 활용한 것에 비해 간편하다.
 *
 * 2. solution2()에서, StringBuilder()의 매개변수로는 "int 형 타입 변수" 가 오지 못 한다.
 *
 *
 */
