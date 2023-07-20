package DFSandBFS;

import java.util.*;

//틀린 풀이! 다시 풀기
// 피잣집이 M개가 새로이 선택되면, 최소배달거리를 다시 계산해야되므로, 무조건 "집" 기준으로 계산해야 한다.
class Main_15 {

    static int n,m;

    public int solution(int[][] graph){
        ArrayList<Point3> list = new ArrayList<>(); //피잣집은 여기 다 모아둠
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == 2) {
                    Point3 point = new Point3(i,j);
                    point.dis = calc(point,graph);
                    list.add(point);
                }
            }
        }
        return calcMinDis(list);
    }

    public int calc(Point3 point, int[][] graph) {
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        int level = 0;
        Queue<Point3> queue = new LinkedList<>();
        queue.offer(point);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point3 cur = queue.poll();
                for(int k=0; k<4; k++) {
                    if(cur.x+dx[k] >=0 && cur.x+dx[k] <=n-1 && cur.y + dy[k] >=0 && cur.y+dy[k] <= n-1) {
                        if(graph[cur.x+dx[k]][cur.y+dy[k]] == 1) return level+1;
                        else queue.offer(new Point3(cur.x+dx[k], cur.y+dy[k]));
                    }
                }
            }
            level++;
        }
        return 30000;
    }

    public int calcMinDis(ArrayList<Point3> list) {
        int answer = 0;
        Collections.sort(list, (p1, p2) -> {return p1.dis - p2.dis;});
        for(int i=0; i<m; i++){
            answer += list.get(i).dis;
        }
        return answer;
    }

    public static void main(String[] args){
        Main_15 main = new Main_15();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.print(main.solution(graph));
    }
}

class Point3{

    int x;
    int y;
    int dis;

    Point3(int x, int y){
        this.x = x;
        this.y = y;
    }
}