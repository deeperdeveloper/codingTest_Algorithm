package twopointers_slidingwindow;

import java.util.Scanner;

/**
 * n을 입력받을 때, n을 2개 이상의 연속된 자연수합으로 나타내는 방법의 수 출력
 */
class Main_5 {

    public int solution(int n){
        int answer = 0;
        int sum = 0;
        int cnt = 0;
        int lt = 1;
        for(int rt=1; rt<n; rt++) {
            sum += rt;
            cnt++;
            while(sum >= n) {
                if(sum == n) answer++;
                if(cnt == 2) break;
                sum -= lt++;
                cnt--;
            }
        }
        return answer;
    }

    public int solution2(int n) {
        int answer = 0, sum=0, lt=0;
        int m = n/2 + 1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) arr[i] = i+1;
        for(int rt=0; rt<m; rt++) {
            sum += arr[rt];
            while(sum >= n) {
                if(sum == n) answer++;
                sum -= arr[lt++];
            }
        }
        return answer;
    }

    //수학적인 요소로 접근
    public int solution3(int number) {
        int answer = 0, tmpSum = 0, maxAmount = 0;
        //1+2+3+...+i <number 가 되게끔 하는 i중 최댓값을 maxAmount에 저장
        for(int i=1; i<number; i++) {
            tmpSum += i;
            if(tmpSum > number) {
                maxAmount = i-1;
                break;
            }
        }
        //연속된 자연수를 p개만큼 더 했을 때, number%p 는 항상 0 또는 p/2가 됨을 활용
        for(int p=2; p<=maxAmount; p++) {
            if(p%2 == 1 && number%p == 0) answer++;
            if(p%2 == 0 && number%p == p/2) answer++;
        }

        return answer;
    }
    //수학적인 요소로 접근 (연속된 자연수 n개가 더해질 때, 항상 1+2+3+4+...+n + (x * n) 으로 나타내짐을 이용)
    public int solution4(int number) {
        int answer = 0, cnt = 1;
        number--;
        while(number > 0){
            cnt++;
            number -= cnt;
            if(number % cnt == 0){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(main.solution(n));
    }
}

/**
 * 풀이에 참고할 만한 사항
 *
 * 1. solution()과 solution2()는 맥락이 거의 같다.
 *      - 다만, solution2()에서는 m으로 solution()에서의 cnt==2를 대체한 것일 뿐.
 *
 *
 * 2.
 *
 *
 *
 *
 *
 */