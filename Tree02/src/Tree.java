public class    Tree {
    Node rootInteger;
    NodeString rootString;

    public void insert(Node node) {
        if (rootInteger == null) {
            rootInteger = node;
            rootInteger.depth = 1;
        } else {
            rootInteger = rootInteger.insertNode(node);
        }
    }

    public void insert(NodeString node) {
        if (rootString == null) {
            rootString = node;
            rootString.depth = 1;
        } else {
            rootString = rootString.insertNode(node);
        }
    }

    public void print() {
        rootInteger.print();
        System.out.println("\n\n");
        rootString.print();
        System.out.println("\n\n");
        rootString.preOrder(rootString);
        System.out.println("\n\n");
        rootInteger.preOrder(rootInteger);
        System.out.println("\n\n");
        rootString.inOrder(rootString);
        System.out.println("\n\n");
        rootInteger.inOrder(rootInteger);


    }
}
