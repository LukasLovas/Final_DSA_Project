public class Node {

    public Node leftChild;
    public Node rightChild;

    public int value;
    public String text;

    Node(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Node insertNode(Node node) {
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

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.value + " ");
        inOrder(node.rightChild);
    }


    public Node rotateLeft(Node A) {
        Node rightNode = A.rightChild;
        A.rightChild = rightNode.leftChild;
        rightNode.leftChild = A;
        return rightNode;
    }

    public Node rotateRight(Node A) {
        Node leftNode = A.leftChild;
        A.leftChild = leftNode.rightChild;
        leftNode.rightChild = A;
        return leftNode;
    }

    public Node splay(Node node, int value) {
        if (node == null || node.value == value) {
            return node;
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

    public Node search(Node node, int value) {
        return splay(node, value);
    }

    public Node deleteNode(Node node, int value){
        Node tempNode;
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
