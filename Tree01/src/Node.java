import static java.lang.Math.abs;

public class Node {

    public Node leftChild;
    public Node rightChild;

    public int depth = 1;
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
                if (leftChild != null){
                    depth = 1 + max(rightChild.depth, leftChild.depth);
                } else {
                    depth = 1 + rightChild.depth;
                }
            }
        } else if (value > node.value) {
            if (leftChild != null) {
                leftChild = leftChild.insertNode(node);
            } else {
                leftChild = node;
                if (rightChild != null){
                    depth = 1 + max(rightChild.depth, leftChild.depth);
                } else {
                    depth = 1 + leftChild.depth;
                }
            }
        }

        if (getBalance(this) > 1 && node.value < this.leftChild.value){
            return rotateRight(this);
        } else if (getBalance(this) < -1 && node.value > this.rightChild.value){
            return rotateLeft(this);
        }
        else if (getBalance(this) > 1 && node.value > this.leftChild.value){
            this.leftChild = rotateLeft(this.leftChild);
            return rotateRight(this);
        }
        else if (getBalance(this) < -1 && node.value < this.rightChild.value){
            this.rightChild = rotateRight(this.rightChild);
            return rotateLeft(this);
        }
        return this;
    }

    public void print(){
        System.out.println("value: " + value + "\tdepth: " + depth + "\tbalance: " + getBalance(this));
        if (leftChild != null){
            leftChild.print();
        }
        if (rightChild != null){
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

    void inOrder(Node node)
    {
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.value + " ");
        inOrder(node.rightChild);
    }

    public int getBalance(Node node){
        if (node == null){
            return 0;
        } else {
            int leftHeight = node.leftChild != null ? node.leftChild.depth : 0;
            int rightHeight = node.rightChild != null ? node.rightChild.depth : 0;
            return leftHeight - rightHeight;
        }
    }

    public Node rotateLeft(Node A){
        Node nodeRight = A.rightChild;
        Node nodeLeft = nodeRight.leftChild;

        nodeRight.leftChild = A;
        A.rightChild = nodeLeft;

        int leftDepth = A.leftChild != null ? A.leftChild.depth : 0;
        int rightDepth = A.rightChild != null ? A.rightChild.depth : 0;
        A.depth = max(leftDepth, rightDepth) + 1;

        leftDepth = nodeRight.leftChild != null ? nodeRight.leftChild.depth : 0;
        rightDepth = nodeRight.rightChild != null ? nodeRight.rightChild.depth : 0;
        nodeRight.depth = max(leftDepth, rightDepth) + 1;

        return nodeRight;
    }

    public Node rotateRight(Node A){
        Node nodeLeft = A.leftChild;
        Node nodeRight = nodeLeft.rightChild;

        nodeLeft.rightChild = A;
        A.leftChild = nodeRight;

        int leftDepth = A.leftChild != null ? A.leftChild.depth : 0;
        int rightDepth = A.rightChild != null ? A.rightChild.depth : 0;
        A.depth = max(leftDepth, rightDepth) + 1;

        leftDepth = nodeLeft.leftChild != null ? nodeLeft.leftChild.depth : 0;
        rightDepth = nodeLeft.rightChild != null ? nodeLeft.rightChild.depth : 0;
        nodeLeft.depth = max(leftDepth, rightDepth) + 1;

        return nodeLeft;
    }

    public int max(int A, int B){
        if (A > B){
            return A;
        } else {
            return B;
        }
    }
    Node searchNode(Node node, int data) {
        if (node == null) {
            System.out.println("Prvok sa v strome nenasiel.\n");
            return node;
        }
        if (node.value == data){
            System.out.println("Najdene:" + node.value + "\n");
            return node;
        }

        if (data < node.value) {
            return searchNode(node.leftChild, data);
        }
        else {
            return searchNode(node.rightChild, data);
        }
    }

    Node findMinimumValue(Node node)
    {
        Node checkedNode = node;
        while (checkedNode.leftChild != null)
            checkedNode = checkedNode.leftChild;

        return checkedNode;
    }


    public Node deleteNode(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.value) {
            node.leftChild = deleteNode(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = deleteNode(node.rightChild, value);
        } else {
            if ((node.leftChild == null) || (node.rightChild == null)) {
                Node tempNode = null;
                if (tempNode == node.leftChild) {
                    tempNode = node.rightChild;
                } else {
                    tempNode = node.leftChild;
                }
                if (tempNode == null) {
                    tempNode = node;
                    node = null;
                } else {
                    node = tempNode;
                }
            } else {
                Node tempNode = findMinimumValue(node.rightChild);
                node.value = tempNode.value;
                node.rightChild = deleteNode(node.rightChild, tempNode.value);
            }
        }

        if (node == null) {
            return node;
        }

        int leftDepth = node.leftChild != null ? node.leftChild.depth : 0;
        int rightDepth = node.rightChild != null ? node.rightChild.depth : 0;
        node.depth = max(leftDepth, rightDepth) + 1;

        if (getBalance(node) > 1 && getBalance(node.leftChild) >= 0)
            return rotateRight(node);
        if (getBalance(node) > 1 && getBalance(node.leftChild) < 0)
        {
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        if (getBalance(node) < -1 && getBalance(node.rightChild) <= 0)
            return rotateLeft(node);
        if (getBalance(node) < -1 && getBalance(node.rightChild) > 0)
        {
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;
    }
}
