package sorting_searching;

import java.util.Scanner;

/**
 * n개의 작업(5~1000)을 입력받고 k개의 캐시 크기가 있다고 하자. 아래 조건에 따른 캐시 상태 출력
 * - 가장 최신 입력받은 작업이 맨 앞에 오며, 이미 작업이 입력되어있는 경우, 해당 작업은 맨 앞으로 옮겨짐.
 * -    이미 입력된 작업 이전의 작업은, 한 칸씩 뒤로 밀려남.
 *
 */
class Main_4 {

    public int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];
        for(int i=0; i<n; i++) {
            int j;
            for(j=0; j<s; j++) {
                if(answer[j] == 0) break;
                else if(answer[j] == arr[i]) break;
            }
            if(j==s) j-=1;
            for(int k=j; k>0; k--) {
                answer[k] = answer[k-1];
            }
            answer[0] = arr[i];
        }
        return answer;
    }

    public int[] solution2(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for(int i=0; i<n; i++) {
            int pos = -1;
            for(int j=0; j<s; j++) {
                if(arr[i] == cache[j]) {
                    pos = j;
                    break;
                }
            }
            if(pos == -1) {
                for(int k=s-1; k>=1; k--) cache[k] = cache[k-1];
            } else {
                for(int k=pos; k>=1; k--) cache[k] = cache[k-1];
            }
            cache[0] = arr[i];
        }
        return cache;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int k=0; k<n; k++) arr[k] = sc.nextInt();
        for(int p : main.solution(s,n ,arr)) System.out.print(p + " ");
    }
}