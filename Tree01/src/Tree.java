public class Tree {
    Node rootInteger;

    public void insert(Node node) {
        if (rootInteger == null) {
            rootInteger = node;
            rootInteger.depth = 1;
        } else {
            rootInteger = rootInteger.insertNode(node);
        }
    }



    public Node searchNode(int value){
        return rootInteger.searchNode(rootInteger, value);
    }

    public void deleteNode(int value){
        rootInteger = rootInteger.deleteNode(rootInteger, value);
    }

    public void print() {
        rootInteger.print();
        System.out.println("\n\n");
        //rootString.print();
        System.out.println("\n\n");
        //rootString.preOrder(rootString);
        System.out.println("\n\n");
        rootInteger.preOrder(rootInteger);
        System.out.println("\n\n");
        //rootString.inOrder(rootString);
        System.out.println("\n\n");
        rootInteger.inOrder(rootInteger);

    }
}
