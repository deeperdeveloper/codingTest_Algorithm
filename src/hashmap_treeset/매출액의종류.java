package hashmap_treeset;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * n일의 매출액 데이터 중, k일 연속의 매출액의 종류를 순서대로 출력
 */

class Main_3 {

    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        answer.add(map.size());

        for(int j=k; j<n; j++) {
            map.put(arr[j-k], map.get(arr[j-k])-1);
            map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            if(map.get(arr[j-k]) == 0) map.remove(arr[j-k]);
            answer.add(map.size());
        }

        return answer;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int p=0; p<n; p++) arr[p] = sc.nextInt();
        for(int t : main.solution(n,k,arr)) System.out.print(t + " ");
    }
}

/**
 * 참고할 만한 사항
 *
 * 1. HashMap 메서드
 *      - map.remove(key)
 *      - map.size()
 */