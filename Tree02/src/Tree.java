public class    Tree {
    Node rootInteger;

    public void insert(Node node) {
        if (rootInteger == null) {
            rootInteger = node;
        } else {
            rootInteger = rootInteger.insertNode(node);
        }
    }


    public void print() {
        rootInteger.print();
        System.out.println("\n\n");
        rootInteger.preOrder(rootInteger);
        System.out.println("\n\n");
        rootInteger.inOrder(rootInteger);
        System.out.println("\n\n");
    }

    public Node deleteNode(int value){
        return rootInteger = rootInteger.deleteNode(rootInteger, value);
    }

    public Node search(int value){
        return rootInteger = rootInteger.search(rootInteger, value);
    }
}
