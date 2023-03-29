package src;

import src.NodeSplay;

public class TreeSplay {
    NodeSplay root;

    public void insert(NodeSplay node) {
        if (root == null) {
            root = node;
        } else {
            root = root.insertNode(node);
        }
    }


    public void print() {
        if(root != null) {
            root.preOrder(root);
            System.out.println("\n\n");
            root.inOrder(root);
        }
    }

    public void deleteNode(int value){
        if(root != null){
            root = root.deleteNode(root, value);
        }
    }

    public NodeSplay search(int value){
        return root = root.search(root, value);
    }
}
