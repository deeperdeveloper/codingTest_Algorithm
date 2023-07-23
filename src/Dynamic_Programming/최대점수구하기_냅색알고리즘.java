package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Scanner;

//이 문제는 조심해야 할 사항이 있음! (아래 주석 참고)
class Main_6 {

    public int solution(int n, int m, ArrayList<Problem> arr) {
        int[] scores = new int[m+1];
        for(int i=0; i<n; i++) {
            int time = arr.get(i).time;
            int score = arr.get(i).score;
            for(int j=m; j>=time; j--) { //for문을 이렇게 돌려야, score가 1번만 더해지게 된다.
                scores[j] = Math.max(scores[j-time] + score, scores[j]);
            }
        }
        return scores[m];
    }

    public static void main(String[] args){
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //문제 수
        int m = sc.nextInt(); //제한시간
        ArrayList<Problem> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            arr.add(new Problem(score,time));
        }
        System.out.print(main.solution(n,m,arr));
    }
}

class Problem {
    int score;
    int time;

    Problem(int score, int time){
        this.score = score;
        this.time = time;
    }
}