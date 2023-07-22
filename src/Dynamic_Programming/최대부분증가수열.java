package Dynamic_Programming;

import java.util.Scanner;

//난이도 있는 문제. 해결해 냄.
//해결의 출발점은, 차례대로 입력받는 숫자를, 무조건 부분수열의 맨 끝에 오게끔 가정했을 때 벌어지는 현상을 관찰.
class Main_3 {

    public int solution(int n, int max, int[] arr) {
        int answer = 0;
        int[] numbers = new int[max+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(arr[j] < arr[i]) numbers[arr[i]] = Math.max(numbers[arr[j]] + 1, numbers[arr[i]]);
                else if(arr[j] == arr[i]) numbers[arr[i]] = Math.max(numbers[arr[i]], 1);
                answer = Math.max(answer, numbers[arr[i]]);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            if(max < arr[i]) max = arr[i];
        }
        System.out.print(main.solution(n,max,arr));
    }
}
