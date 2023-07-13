package twopointers_slidingwindow;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *  0또는 1로 이루어져 있는, 길이가 n인 수열에서, k번 0->1로 바꾸는 것이 허용될 때, 1이 최대로 연속할 수 있는 길이 최댓값
 */
class Main_6 {

    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for(int rt=0; rt<n; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > k) { //lt 위치 조정
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1); //매번 rt마다 부분 수열 길이 체크
        }
        return answer;
    }

    //0의 위치를 저장하여 풀이하는 방법 (매우 복잡)
    public int solution2(int n, int k, int[] arr) {
        int answer = 0;
        ArrayList<Integer> zeros = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(arr[i] == 0) zeros.add(i);
        }

        int lenZeros = zeros.size();
        int lt=0, rt=k;
        if(lenZeros <= k) answer = n;
        else {
            answer = Math.max(answer, zeros.get(rt++));
            while(rt != lenZeros) {
                answer = Math.max(answer, zeros.get(rt)-zeros.get(lt)-1);
                lt++;
                rt++;
            }
        }
        answer = Math.max(answer, (n-1)-zeros.get(lt));
        return answer;
    }

    public static void main(String[] args){
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(main.solution(n,k,arr));
    }
}

/**
 * 참고할 만한 사항
 * 1. solution()이 solution2() 보다 월등히 깔끔함.
 *  - 결국 둘 다 핵심은, lt랑 rt 사이에 0이 2개 위치하게끔 위치시키는 것임.
 *  - solution2()는 너무 모든 경우를 적나라하게 코드로 나타내려 하지 않았나.... 라는 생각이 듦.
 */