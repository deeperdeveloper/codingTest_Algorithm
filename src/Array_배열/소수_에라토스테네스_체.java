package Array_배열;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * n을 입력받을 떄, n 이하의 소수의 갯수 구하기
 */
class Main_5 {

    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1]; //소수 판별

        for(int i=2; i<=n; i++) {
            if(arr[i]==0) {
                answer++;
                for(int j=i+i; j<=n; j+=i) { //(중요!) i가 소수라면, i의 배수들은 모두 제외시킬 것이다.
                    if(j%i == 0) arr[j] = 1;
                }
            }
        }
        return answer;
    }
    
    //시간 초과
    public int solution2(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for(int i=3; i<=n; i++) {
            int tmp = 0;
            for(int k : primes) {
                if(i % k ==0) break;
                else tmp++;
            }
            if(tmp == primes.size()) primes.add(i);
        }
        return primes.size();
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(main.solution(n));
    }
}

/**
 * 풀이에 참고할 만한 사항.
 * 1. 이 문제는 시간 초과가 뜨기 딱 좋다.
 *  - solution()의 풀이 방법이 제일 최적화가 되어 있다. (필요한 부분에 대해서만 정확하게 연산을 진행함)
 *
 */