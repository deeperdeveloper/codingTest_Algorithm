package recursive_tree_graph;

/**
 * 전위순회, 중위순회, 후위순회 구현하기. (비슷한 방식으로, 전위순회와 후위순회도 구현해보기)
 * (이진트리는 아래와 같다)
 *                1
 *            /      \
 *           2        3
 *         /  \      /  \
 *        4   5     6   7
 *
 *
 */

class Main_5 {

    Node root;

    public void dfs(Node node) {
        if(node == null) return;
        
        //전위순회
        System.out.print(node.data);
        dfs(node.lt);
        dfs(node.rt);

        /* //중위순회
        dfs(node.lt);
        System.out.print(node.data);
        dfs(node.rt);*/

        /*//후위순회
        dfs(node.lt);
        dfs(node.rt);
        System.out.print(node.data);*/
    }

    public static void main(String[] args) {
        Main_5 tree = new Main_5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.dfs(tree.root);
    }
}


class Node {

    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
    }
}


/**
 *
 *
 */