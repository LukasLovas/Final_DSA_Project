public class Tree {
    Node root;

    Node TreeInsert(Node node, int data){
        int tempHeight;
        if (node == null){
            return new Node(data,tempHeight); //TODO nefunguje
        }

        if (data < node.data){
            tempHeight = node.height;
            node.left = TreeInsert(node.left,data);
        }
        else if (data > node.data){
            tempHeight = node.height;
            node.right = TreeInsert(node.right,data);
        }
        else{
            return node;
        }
        return node;
    }

    void indorer(Node node){
        if(node == null){
            return;
        }
        indorer(node.left);
        System.out.printf("%d %s %d\r\n",node.data,node.value,node.height);
        indorer(node.right);
    }

    Node TreeSearch(Node node,int data) {
        if (node == null) {
            System.out.println("Prvok sa v strome nenasiel.");
            return node;
        }
        if (node.data == data){
            System.out.println("Najdene:" + node.data);
            return node;
        }

        if (data < node.data) {
            return TreeSearch(node.left, data);
        }
        else {
            return TreeSearch(node.right, data);
        }
    }

    Node TreeDelete(Node node,int data) {
        if (node == null) {
            System.out.print("Cislo sa v strome nenachadza");
            return node;
        }
        if (data < node.data) {
            node.left = TreeDelete(node.left, data);
        } else if (data > node.data) {
            node.right = TreeDelete(node.right, data);
        }
        else{
            if(node.left == null && node.right == null){
                node = null;
            }
            else if(node.right != null && node.left == null){
                node = node.right;
            }
            else if(node.right == null){
                node = node.left;
            }
            else if(node.left != null && node.right != null){
                int temp = node.data;
                node.data = successor(node.right);
                node.right = TreeDelete(node.right, node.right.data);
                System.out.print("V strome bol vymazany prvok " + temp + " a bol nahradeny prvkom " + node.data + "\r\n");
            }
        }
        return node;
    }

    int successor(Node node){
        int successorData = node.data;
        while(node.left != null){
            successorData = node.left.data;
            node = node.left;
        }
        return successorData;
    }

    int checkHeight(Node node){
        if (node == null){
            return -1;
        }
        else{
            return node.height;
        }
    }

    void changeHeight(Node node){
        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);
        if(leftHeight < rightHeight){
            node.height = rightHeight + 1;
        }
        else{
            node.height = leftHeight + 1;
        }
    }
    int getHeavierSide(Node node){
        return checkHeight(node.right) - checkHeight(node.left);
    }

    //ROTACIE

    Node rotateRight(Node node){
        Node tempLeftChild = node.left;
        node.left = tempLeftChild.right;
        tempLeftChild.right = node;
        changeHeight(node);
        changeHeight(tempLeftChild);
        return tempLeftChild;
    }

    Node rotateLeft(Node node) {
        Node tempRightChild = node.right;
        node.right = tempRightChild.left;
        tempRightChild.left = node;
        changeHeight(node);
        changeHeight(tempRightChild);

        return tempRightChild;
    }
}
//TODO dorobit updatovanie node.height, rotacie