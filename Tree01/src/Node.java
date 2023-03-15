public class Node {
    int data;
    String value = "1";
    Node left;
    Node right;

    int height = 0;


    public Node(int data){
        this.data = data;
    }
    public Node(int data,int height){
        this.data = data;
        this.height = height + 1;
    }
}
