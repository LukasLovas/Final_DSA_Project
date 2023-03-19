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
}
