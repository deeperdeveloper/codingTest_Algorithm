package twopointers_slidingwindow;

import java.util.Scanner;

/**
 * n개의 수열을 입력받고, 부분 수열 목표합 m을 입력받을 때, 합이 m인 연속부분수열 갯수
 */
class Main_4 {

    public int solution(int n, int m, int[] arr) {
        int answer = 0; //경우의 수
        int subSum = arr[0]; //부분 수열 합 초기값
        int pt1= 0;
        int pt2= 1;
        while(pt2<n) {
            if(subSum < m) subSum += arr[pt2++];
            else if(subSum == m) {
                answer++;
                subSum -= arr[pt1++];
                subSum += arr[pt2++];
            } else {
                subSum -= arr[pt1++];
                if(pt1 == pt2) subSum += arr[pt2++]; //pt1 < pt2로 만들어주는 로직
            }
        }

        if(subSum == m) answer++; //if(subSum<m)문을 거쳐 pt2 == n 인 경우, subSum이 m과 같은지를 체크해주어야 한다.

        return answer;
    }

    public int solution2(int n, int m, int[] arr) {
        int answer = 0; //경우의 수
        int subSum = 0; //부분 수열 합 초깃값
        int lt = 0;
        for(int rt=0; rt<n; rt++) {
            if(subSum < m) subSum += arr[rt];
            while(subSum >= m) {
                if(subSum == m) answer++;
                subSum -= arr[lt++];
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열 원소 갯수
        int m = sc.nextInt(); // 목표하고자 하는 부분 수열의 합
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(main.solution(n,m,arr));
    }
}

/**
 * 참고할 만한 사항
 * 1. solution2() 에서는 rt를 for문을 돌려서 자동으로 증가하게끔 풀이
 *      - 그리고 solution()에서 rt == n인 경우에 대해서 subSum을 check하는 로직은 while문 안에 없었음.
 *      => 반면, solution2()에서는, rt == n인 경우의 subSum까지 모두 고려함.
 *      ==> 해당 부분 유심하게 관찰하고, rt == n인 경우를 어떻게 안 빠뜨리고 로직에 넣을지 고민해보기.
 *
 *
 */