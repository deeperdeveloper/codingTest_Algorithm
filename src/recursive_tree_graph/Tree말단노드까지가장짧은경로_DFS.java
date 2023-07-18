package recursive_tree_graph;

/**
 * 아래의 트리에 대해, root에서 말단 노드까지 가장 짧은 거리를 구하기 (dfs 이용)
 *
 *                1
 *            /      \
 *           2        3
 *         /  \
 *        4   5
 *
 *
 */

class Main_9 {

    Node root;

    public int dfs(int level, Node node){
        if(node.lt == null && node.rt == null) return level;
        return Math.min(dfs(level+1, node.lt), dfs(level+1, node.rt));
    }

    public static void main(String[] args){
        Main_9 tree = new Main_9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.print(tree.dfs(0, tree.root));
    }
}
