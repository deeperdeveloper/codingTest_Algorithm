package sorting_searching;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * n개의 좌표를 입력받을 때, 오름차순으로 정렬하기
 * (단, x값 우선 오름차순 정렬, 이후 y값 오름차순 정렬 규칙)
 */
class Main_7 {

    public ArrayList<Point> solution(int n, ArrayList<Point> arrList) {
        Collections.sort(arrList);
        return arrList;
    }

    public static void main(String[] args){
        Main_7 main = new Main_7();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arrList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arrList.add(new Point(x,y));
        }
        for(Point p : main.solution(n,arrList)) System.out.println(p.x + " " + p.y);
    }
}

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}


/**
 *
 * 공부해야 하는 사항.
 *
 * 1. Comparable, Comparator 차이
 *      - java.lang.Comparable vs java.util.Comparator
 *      - 자기 자신과 비교 vs 두 매개변수와의 비교
 *          - 따라서, Comparator 인터페이스의 경우는 보통 익명구현객체(람다식)으로 구현하여 두 매개변수를 비교한다.
 *          - 반면, Comparable 인터페이스의 경우는 비교하고자 하는 원소의 class에서 구현한다.
 *          - 공통점
 *              - 선행원소 - 후행원소 < 0 이면, 위치를 바꾸지 않는다.
 *              - 선행원소 - 후행원소 > 0 이면, 위치를 바꾼다.
 *       - Comparable 인터페이스 구현 시, compareTo(o)를 구현 (즉, this와 o의 비교)
 *       - Comparator 인터페이스 구현 시, compare(o1, o2)를 구현 (즉, o1과 o2의 비교)
 *
 *
 *
 * 출처 : https://st-lab.tistory.com/243
 */