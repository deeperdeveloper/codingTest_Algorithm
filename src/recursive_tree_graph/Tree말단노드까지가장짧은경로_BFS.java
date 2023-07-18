package recursive_tree_graph;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 아래의 트리에 대해, root에서 말단 노드까지 가장 짧은 거리를 구하기 (bfs 이용)
 *
 *                1
 *            /      \
 *           2        3
 *         /  \
 *        4   5
 *
 *
 */

class Main_10 {

    Node root;

    public int bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node cur = queue.poll();
                if(cur.lt == null && cur.rt == null) return level;
                else if(cur.lt == null) queue.offer(cur.rt);
                else if(cur.rt == null) queue.offer(cur.lt);
                else {
                    queue.offer(cur.lt);
                    queue.offer(cur.rt);
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args){
        Main_10 tree = new Main_10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.print(tree.bfs(tree.root));
    }
}
