package src;

public class TreeAVL {
    NodeAVL root;

    public void insert(NodeAVL node) { //wrapper for insert method
        if (root == null) {
            root = node;
            root.height = 1;
        } else {
            root = root.insertNode(node);
        }
    }

    public NodeAVL searchNode(int key){
        return root.searchNode(root, key);
    } //wrapper for search method

    public void deleteNode(int value){ //wrapper for delete method
        if(root != null){
        root = root.deleteNode(root, value);
        }
        if (root == null){
            //System.out.println("true");
        }
    }

    public void print() {
        if(root != null) {
            root.preOrder(root);
            System.out.println("\n\n");
            root.inOrder(root);
        }
    }
}
