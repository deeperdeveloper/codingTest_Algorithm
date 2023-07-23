package Dynamic_Programming;

import java.util.Scanner;

class Main_5 {

    //돈을 정확하게 맞춰서 거슬러주지 못하면, 0가지로 입력한다는 점을 인지하기
    public int solution(int n, int[] arr, int m) {
        int[] moneys = new int[m+1];
        for(int i=0; i<n; i++) {
            for(int j=arr[i]; j<=m; j++) {
                if(j % arr[i] == 0) { //arr[i] 배수 인 금액에 대해서 다 처리
                    if(moneys[j] == 0) moneys[j] = j / arr[i];
                    else moneys[j] = Math.min(moneys[j], moneys[j-arr[i]]+1);
                }
                //arr[i] 배수 이외의 금액에 대해서 다 처리
                else if(moneys[j-arr[i]] != 0) moneys[j] = Math.min(moneys[j], moneys[j-arr[i]]+1);
            }
        }
        return moneys[m];
    }

    public static void main(String[] args){
        Main_5 main = new Main_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(main.solution(n, arr, m));
    }

}

/**
 * 모범 답안은 더 간단함. 참고해보기.
 */