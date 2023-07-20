package GreedyAlgorithm;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main_2 {

    public int solution(int n, ArrayList<Meeting> arrList) {
        int answer = 0;
        int tmpEndTime = Integer.MIN_VALUE;
        Collections.sort(arrList); //endTime 기준 오름차순 정렬
        for(Meeting m : arrList) {
            if(m.startTime >= tmpEndTime) {
                tmpEndTime = m.endTime;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_2 main = new Main_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> arrList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arrList.add(new Meeting(s,e));
        }
        System.out.print(main.solution(n, arrList));
    }
}

class Meeting implements Comparable<Meeting>{
    int startTime;
    int endTime;

    Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting m) {
        if(this.endTime == m.endTime) return this.startTime - m.startTime; //주의할 것! 이 코드가 없다면, 통과하지 못하는 테스트 케이스 존재
        else return this.endTime - m.endTime;
    }
}