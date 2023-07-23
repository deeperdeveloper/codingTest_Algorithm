package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main_4 {

    public int solution(int n, ArrayList<Brick> arrList) {
        int answer = 0;
        Collections.sort(arrList);
        for(int i=0; i<n; i++) {
            for(int j=i; j>=0; j--) {
                if(arrList.get(i).weight >= arrList.get(j).weight) {
                    arrList.get(i).maxHeight = Math.max(arrList.get(i).height + arrList.get(j).maxHeight, arrList.get(i).maxHeight);
                    answer = Math.max(answer, arrList.get(i).maxHeight);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> arrList = new ArrayList<>();
        for(int i=0; i<n; i++){
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arrList.add(new Brick(area, height, weight));
        }
        System.out.print(main.solution(n, arrList));
    }
}

class Brick implements Comparable<Brick> {

    int area;
    int height;
    int weight;
    int maxHeight = 0;

    Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick b) {
        return this.area - b.area;
    }
}