

public class Main {

    public static void main(String[] args){
        Tree tree = new Tree();
        tree.root = tree.TreeInsert(tree.root,7);
        tree.root = tree.TreeInsert(tree.root,5);
        tree.root = tree.TreeInsert(tree.root,13);
        tree.root = tree.TreeInsert(tree.root,3);
        tree.root = tree.TreeInsert(tree.root,6);
        tree.root = tree.TreeInsert(tree.root,2);
        tree.root = tree.TreeInsert(tree.root,4);
        tree.root = tree.TreeInsert(tree.root,10);
        tree.root = tree.TreeInsert(tree.root,18);

        //System.out.printf("%d %d %d",tree.root.data, tree.root.left.data, tree.root.right.data);
        //for (int i = 1;i < 1001;i++){
        //tree.root = tree.TreeInsert(tree.root,i);
        //}
        tree.TreeDelete(tree.root,3);
        tree.TreeDelete(tree.root,18);
        tree.TreeDelete(tree.root,54);
        tree.indorer(tree.root);
        //System.out.println(tree.root.left.data);
        //tree.TreeSearch(tree.root,1001);
        //tree.TreeSearch(tree.root,15);


    }
}
