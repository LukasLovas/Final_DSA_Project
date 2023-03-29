package src;

public class NodeAVL {

    public NodeAVL leftChild;
    public NodeAVL rightChild;

    public int height = 1;
    public int value;
    public String text;

    NodeAVL(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public NodeAVL insertNode(NodeAVL node) {
        if (value < node.value) {
            if (rightChild != null) {
                rightChild = rightChild.insertNode(node);
            } else {
                rightChild = node;
                if (leftChild != null){
                    height = 1 + max(rightChild.height, leftChild.height);
                } else {
                    height = 1 + rightChild.height;
                }
            }
        } else if (value > node.value) {
            if (leftChild != null) {
                leftChild = leftChild.insertNode(node);
            } else {
                leftChild = node;
                if (rightChild != null){
                    height = 1 + max(rightChild.height, leftChild.height);
                } else {
                    height = 1 + leftChild.height;
                }
            }
        }

        if (getBalance(this) > 1 && node.value < this.leftChild.value){
            return rotateRight(this); //rotate right - left-heavy
        } else if (getBalance(this) < -1 && node.value > this.rightChild.value){
            return rotateLeft(this); //rotate left - right-heavy
        }
        else if (getBalance(this) > 1 && node.value > this.leftChild.value){
            this.leftChild = rotateLeft(this.leftChild);
            return rotateRight(this);   //rotate left-right - left-heavy
        }
        else if (getBalance(this) < -1 && node.value < this.rightChild.value){
            this.rightChild = rotateRight(this.rightChild);
            return rotateLeft(this);    //rotate right-left - right-heavy
        }
        return this;
    }

    public void print(){
        System.out.println("value: " + value + "\tdepth: " + height + "\tbalance: " + getBalance(this));
        if (leftChild != null){
            leftChild.print();
        }
        if (rightChild != null){
            rightChild.print();
        }
    }

    void preOrder(NodeAVL node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    void inOrder(NodeAVL node)
    {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.value + " ");
            inOrder(node.rightChild);
        }
    }

    public int getBalance(NodeAVL node){
        if (node == null){
            return 0;
        } else {
            int leftHeight = node.leftChild != null ? node.leftChild.height : 0;
            int rightHeight = node.rightChild != null ? node.rightChild.height : 0;
            return leftHeight - rightHeight;
        }
    }

    public NodeAVL rotateLeft(NodeAVL A){
        NodeAVL nodeRight = A.rightChild;
        NodeAVL nodeLeft = nodeRight.leftChild;

        nodeRight.leftChild = A;
        A.rightChild = nodeLeft;

        int leftDepth = A.leftChild != null ? A.leftChild.height : 0;
        int rightDepth = A.rightChild != null ? A.rightChild.height : 0;
        A.height = max(leftDepth, rightDepth) + 1;

        leftDepth = nodeRight.leftChild != null ? nodeRight.leftChild.height : 0;
        rightDepth = nodeRight.rightChild != null ? nodeRight.rightChild.height : 0;
        nodeRight.height = max(leftDepth, rightDepth) + 1;

        return nodeRight;
    }

    public NodeAVL rotateRight(NodeAVL A){
        NodeAVL nodeLeft = A.leftChild;
        NodeAVL nodeRight = nodeLeft.rightChild;

        nodeLeft.rightChild = A;
        A.leftChild = nodeRight;

        int leftDepth = A.leftChild != null ? A.leftChild.height : 0;
        int rightDepth = A.rightChild != null ? A.rightChild.height : 0;
        A.height = max(leftDepth, rightDepth) + 1;

        leftDepth = nodeLeft.leftChild != null ? nodeLeft.leftChild.height : 0;
        rightDepth = nodeLeft.rightChild != null ? nodeLeft.rightChild.height : 0;
        nodeLeft.height = max(leftDepth, rightDepth) + 1;

        return nodeLeft;
    }

    public int max(int A, int B){
        if (A > B){
            return A;
        } else {
            return B;
        }
    }
    NodeAVL searchNode(NodeAVL node, int data) {
        if (node == null) {
            System.out.println("Prvok sa v strome nenasiel.\n");
            return node;
        }
        if (node.value == data){
            //System.out.println("Najdene:" + node.value + "\n");
            return node;
        }

        if (data < node.value) {
            return searchNode(node.leftChild, data);
        }
        else {
            return searchNode(node.rightChild, data);
        }
    }

    NodeAVL findMinimumValue(NodeAVL node)
    {
        NodeAVL checkedNode = node;
        while (checkedNode.leftChild != null)
            checkedNode = checkedNode.leftChild;

        return checkedNode;
    }


    public NodeAVL deleteNode(NodeAVL node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.value) {
            node.leftChild = deleteNode(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = deleteNode(node.rightChild, value);
        } else {
            if ((node.leftChild == null) || (node.rightChild == null)) {
                NodeAVL tempNode = null;
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
                NodeAVL tempNode = findMinimumValue(node.rightChild);
                node.value = tempNode.value;
                node.rightChild = deleteNode(node.rightChild, tempNode.value);
            }
        }

        if (node == null) {
            return node;
        }

        int leftDepth = node.leftChild != null ? node.leftChild.height : 0;
        int rightDepth = node.rightChild != null ? node.rightChild.height : 0;
        node.height = max(leftDepth, rightDepth) + 1;

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
