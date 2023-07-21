package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * 아이디어 : 고객의 입장시간/퇴장시간만 고려하면 된다.
 * => 입장시간과 퇴장시간을 구분할 수 있는 데이터를 추가하여, 객체로서 정의하면 될 것이다.
 *
 */

class Main_3 {

    public int solution(int n, ArrayList<Time> arr) {
        int answer = 0;
        Collections.sort(arr);
        int cnt = 0;
        for(Time t : arr) {
            if(t.state == 's') {
                cnt++;
                answer = Math.max(answer, cnt);
            } else cnt--;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Time(a, 's'));
            arr.add(new Time(b, 'e'));
        }
        System.out.print(main.solution(n, arr));
    }
}

class Time implements Comparable<Time> {
    int time;
    char state;

    Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time t) {
        if(this.time == t.time) return this.state-t.state;
        else return this.time - t.time;
    }
}




/**
 * 아래의 풀이도 가능하다. 다만, 모든 경우를 고려하였기에, 위에서 적용한 Greedy Algorithm 보다는 효율성이 뒤떨어진다.
 *
 * import java.util.Scanner;
 *
 *
 * class Main_3 {
 *
 *     public static void main(String[] args){
 *         Main_3 main = new Main_3();
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         int[] arr = new int[72+1];
 *         for(int i=0; i<n; i++) {
 *             int a = sc.nextInt();
 *             int b = sc.nextInt();
 *             for(int k=a; k<b; k++) arr[k]++;
 *         }
 *         int max = -1;
 *         for(int i=0; i<73; i++) {
 *             if(max < arr[i]) max = arr[i];
 *         }
 *         System.out.print(max);
 *     }
 * }
 *
 *
 */