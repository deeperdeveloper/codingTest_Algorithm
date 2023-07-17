package sorting_searching;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 일렬로 나열된 n개의 노래들을, m개의 길이가 같은 DVD에 담게끔 하는 최소의 DVD 길이를 구하기.
 * (단, 노래는 연속적으로 나열된 노래들만 하나의 DVD에 넣을 수 있다)
 */
class Main_9 {

    public int count(int mid, int[] arr){
        int sum = 0;
        int cnt = 1;
        for(int x : arr) {
            if(sum + x > mid) {
                sum = x;
                cnt++;
            } else sum += x;
        }
        return cnt;
    }

    public int solution(int n, int[] arr, int m){
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(mid, arr) <= m) {
                rt = mid-1;
                answer = mid;
            } else lt = mid+1;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_9 main = new Main_9();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = sc.nextInt();
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print(main.solution(n,arr,m));
    }
}

/**
 * 반성해야 할 점 (이 문제를 풀지 못 함)
 * 1. 우선, 이 풀이는 아래의 아이디어에 근거한다.
 *    - 결국, 1개의 노래조차 못 담는 경우가 존재한다면?
 *       => 그래서, 길이가 가장 긴 노래의 길이부터 고려해보자
 *
 *    - 1개의 DVD에 다 담는다면?
 *      => 복잡하게 생각할 거 없이, 그냥 노래의 길이를 다 더하면 된다.
 *
 *   1-1. sum이 원하는 값보다 넘치기 직전까지 담는 경우의 코드를 잘 봐라.
 *      - 나는 생각하지 못 함(count() 보기)
 *
 *   1-2. rt = mid로 하면 시간초과가 뜬다.
 *      - rt = mid-1로 쓰는 습관을 들일 것.
 *      - 논리적으로도, 답이 1개뿐이어야 하므로 rt = mid-1로 쓰고, answer = mid로 하게 되면 문제가 없다.
 *
 *   1-3. 결국 문제를 테스트 하다 보면, 아예 처음부터 길이에 대한 이진검색을 하는 것이 제일 효율적임을 알 수 있다.
 *      - 나의 경우는, 맨 첫번째 구간의 합을 기준으로, 이후 구간에서 첫번째 구간 합을 초과하는 경우가 나올 때까지, 첫번째 구간의 합을 구하려 함.
 *      => 중복된 계산이 너무 많이 들어감을 알 수 있다. (피해야 하는 풀이!)
 *
 *
 *
 */