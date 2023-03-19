public class NodeString {

    public NodeString leftChild;
    public NodeString rightChild;

    public int depth = 1;
    public String value;

    NodeString(String value) {
        this.value = value;
    }

    public NodeString insertNode(NodeString node) {
        if (value.compareTo(node.value) > 0) {
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
        } else if (value.compareTo(node.value) < 0) {
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

        //if (getBalance(this) > 1 && node.value < this.leftChild.value){
        if (getBalance(this) > 1 && node.value.compareTo(this.leftChild.value) > 0){
            return rotateRight(this);
        } else if (getBalance(this) < -1 && node.value.compareTo(this.rightChild.value) < 0){
            return rotateLeft(this);
        }
        else if (getBalance(this) > 1 && node.value.compareTo(this.leftChild.value) < 0){
            this.leftChild = rotateLeft(this.leftChild);
            return rotateRight(this);
        }
        else if (getBalance(this) < -1 && node.value.compareTo(this.rightChild.value) > 0){
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

    void preOrder(NodeString node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    void inOrder(NodeString node)
    {
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.value + " ");
        inOrder(node.rightChild);
    }

    public int getBalance(NodeString node){
        if (node == null){
            return 0;
        } else {
            int leftHeight = node.leftChild != null ? node.leftChild.depth : 0;
            int rightHeight = node.rightChild != null ? node.rightChild.depth : 0;
            return leftHeight - rightHeight;
        }
    }

    public NodeString rotateLeft(NodeString A){
        NodeString nodeRight = A.rightChild;
        NodeString nodeLeft = nodeRight.leftChild;

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

    public NodeString rotateRight(NodeString A){
        NodeString nodeLeft = A.leftChild;
        NodeString nodeRight = nodeLeft.rightChild;

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
