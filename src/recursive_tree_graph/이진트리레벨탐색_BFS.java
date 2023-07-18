package recursive_tree_graph;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 이진트리레벨탐색 문제(BFS 활용)
 */
class Main_7 {

    Node root;

    public void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(L + " : ");
            for(int i=0; i<len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Main_7 tree = new Main_7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }
}
