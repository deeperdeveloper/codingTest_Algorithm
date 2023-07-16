package stack_queue;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * n명의 환자들이 위험도를 순서대로 입력받을 때, k번째 환자는 몇 번째로 진료를 받을지 출력
 * (위험도가 높은 환자가 우선순위이며, 위험도가 동일하면 우선 들어온 환자가 진찰받음)
 */

class Main_8 {

    public int solution(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i=0; i<n; i++) q.offer(new Person(i,arr[i])); //몇 번째로 들어온 환자인지 알아야 하므로, Person 객체를 만듦.
        while(!q.isEmpty()) {
            Person tmp = q.poll();
            boolean flag = true;
            for(Person p : q) {
                if (p.priority > tmp.priority) {
                    q.offer(tmp);
                    flag = false;
                    break;
                }
            }
            if(flag) { //queue에서 뽑은 사람이 진찰대상인 경우, 몇 번째인지 새기기.
                answer++;
                if(tmp.id == m) break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_8 main = new Main_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.print(main.solution(n,m,arr));
    }
}

class Person {

    public int id;
    public int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}