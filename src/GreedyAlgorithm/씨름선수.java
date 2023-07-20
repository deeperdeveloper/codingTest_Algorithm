package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main_1 {
    public int solution(int n, ArrayList<Person> arr) {
        int answer = 0;
        Collections.sort(arr); //몸무게 순으로 내림차순 정렬
        int maxHeight = arr.get(0).height;
        answer++;
        for(int i=1; i<n; i++) {
            if(arr.get(i).height > maxHeight) {
                answer++;
                maxHeight = arr.get(i).height;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_1 main = new Main_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Person(height, weight));
        }
        System.out.print(main.solution(n,arr));
    }
}

class Person implements Comparable<Person>{
    int height;
    int weight;

    Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person p) {
        return -(this.weight - p.weight); //몸무게 내림차순으로 정렬
    }
}

/**
 * <참고로 알아둘 사항>
 * - 반드시 더 자세하게 정리할 것. 현재에는 간단하게 정리하고 바로 문제풀이 진입
 *
 * 1. Greedy Algorithm
 *    - 부분적으로 최적의 해를 선택 시, 그 해가 전체 문제의 최적 해를 구성하는 원리를 이용
 *      => 따라서, Greedy Algorithm 적용 시, 해당 원리가 적용됨을 증명해야 한다.
 *      => 위 문제의 경우, Greedy Algorithm 적용을 위해 Arrays.sort()를 활용하였다.
 *
 *    1-1. Dynamic Programming 과 가장 큰 차이는, 모든 경우를 따지지 않는다
 *      => 또한, 작은 문제가 중복해서 나타나지 않는다는 것 역시 차이점.
 *
 *
 * 2. Dynamic Programming
 *    - 전체 문제를 작은 문제 여러개로 쪼개어서, 작은 문제에서 나온 답을 "메모이제이션"해서, 큰 문제를 풀어나가는 기법
 *    => 사실상 모든 경우를 "효과적으로" 따져서 푸는 문제 방법.
 *    => brute-force 방법이라고 볼 수 있다.
 *
 *    2-1. 예) 0-1 배낭문제
 *
 *    2-2. "작은 문제에서 나온 답"을 활용해야 하므로, 하위 문제가 중복해서 나타나는 것이 가장 큰 특징.
 *
 *
 *
 * 3. 출처
 *    - https://sncap.tistory.com/634 (Greedy Alg 와 Dynamic programming의 차이)
 *    - https://ihp001.tistory.com/134
 *    - https://sskl660.tistory.com/88
 *    - https://sskl660.tistory.com/87
 *
 */