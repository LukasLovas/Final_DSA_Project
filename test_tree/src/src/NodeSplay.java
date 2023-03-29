package src;

public class NodeSplay {

    public NodeSplay leftChild;
    public NodeSplay rightChild;

    public int value;
    public String text;

    NodeSplay(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public NodeSplay insertNode(NodeSplay node) {
        if (value < node.value) {
            if (rightChild != null) {
                rightChild = rightChild.insertNode(node);
            } else {
                rightChild = node;
            }
        } else if (value > node.value) {
            if (leftChild != null) {
                leftChild = leftChild.insertNode(node);
            } else {
                leftChild = node;
            }
        }
        //System.out.println("Inserted: " + this);
        return this;
    }

    public void print() {
        System.out.println("value: " + value);
        if (leftChild != null) {
            leftChild.print();
        }
        if (rightChild != null) {
            rightChild.print();
        }
    }

    void preOrder(NodeSplay node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    void inOrder(NodeSplay node) {
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.value + " ");
        inOrder(node.rightChild);
    }


    public NodeSplay rotateLeft(NodeSplay A) {
        NodeSplay rightNode = A.rightChild;
        A.rightChild = rightNode.leftChild;
        rightNode.leftChild = A;
        return rightNode;
    }

    public NodeSplay rotateRight(NodeSplay A) {
        NodeSplay leftNode = A.leftChild;
        A.leftChild = leftNode.rightChild;
        leftNode.rightChild = A;
        return leftNode;
    }

    public NodeSplay splay(NodeSplay node, int value) {
        if (node == null || node.value == value) {
            if (node == null){
                //System.out.println("Not found");
                return null;
            }
            else{
                //System.out.println("Node found: "+ node);
                return node;
            }
        }
        if (node.value > value) {
            if (node.leftChild == null) {
                return node;
            }
            if (node.leftChild.value > value) {
                node.leftChild.leftChild = splay(node.leftChild.leftChild, value);
                node = rotateRight(node);
            } else if (node.leftChild.value < value) {
                node.leftChild.rightChild = splay(node.leftChild.rightChild, value);
                if (node.leftChild.rightChild != null) {
                    node.leftChild = rotateLeft(node.leftChild);
                }
            }
            if (node.leftChild == null) {
                return node;
            } else {
                return rotateRight(node);
            }
        } else {
            if (node.rightChild == null) {
                return node;
            }
            if (node.rightChild.value > value) {
                node.rightChild.leftChild = splay(node.rightChild.leftChild, value);
                if (node.rightChild.leftChild != null) {
                    node.rightChild = rotateRight(node.rightChild);
                }
            } else if (node.rightChild.value < value) {
                node.rightChild.rightChild = splay(node.rightChild.rightChild, value);
                node = rotateLeft(node);
            }
            if (node.rightChild == null) {
                return node;
            } else {
                return rotateLeft(node);
            }
        }
    }

    public NodeSplay search(NodeSplay node, int value) {
        return splay(node, value);
    }

    public NodeSplay deleteNode(NodeSplay node, int value){
        //System.out.println("true");
        NodeSplay tempNode;
        if (node == null){
            return null;
        }

        node = splay(node, value);

        if (value != node.value){
            return node;
        }

        if (node.leftChild == null){
            tempNode = node;
            node = node.rightChild;
        } else {
            tempNode = node;
            node = splay(node.leftChild, value);
            node.rightChild = tempNode.rightChild;
        }

        return node;
    }

    public int max(int A, int B) {
        if (A > B) {
            return A;
        } else {
            return B;
        }
    }
}
