package sorting_searching;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * n명의 키가 오름차순으로 정렬되어 있을 때, 철수랑 A랑만 자리를 바꿨다고 하자. (철수 키 > A키)
 * => 이 상태에서, 앞에서부터 번호를 부여할 때 철수랑 A가 받은 번호를 출력
 */
class Main_6 {

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] arr2 = new int[n];
        for(int i=0; i<n; i++) arr2[i] = arr[i]; //arr복제
        Arrays.sort(arr);

        for(int j=0; j<n; j++) {
            if(arr2[j] != arr[j]) answer.add(j+1);
        }
        return answer;
    }

    public static void main(String[] args){
        Main_6 main = new Main_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int k : main.solution(n,arr)) System.out.print(k + " ");
    }

}
