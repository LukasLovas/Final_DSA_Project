import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(new Node(9,"string"));
        insertValues(tree);

        tree.print();
        System.out.println(tree.search(5).value);
        tree.print();
        System.out.println(tree.search(2).value);
        tree.print();
        System.out.println(tree.search(5).value);
        tree.print();
        System.out.println(tree.search(10).value);
        tree.print();
        System.out.println(tree.search(5).value);
        tree.print();

        tree.deleteNode(10);
        tree.print();


    }

    public static void insertValues(Tree tree){
        List<Integer> values = new ArrayList<>(Arrays.asList(10,15,1,5,2,3,75,4,17,20,6));
        List<String> stringValues = new ArrayList<>(Arrays.asList("ahoj", "jablko", "zero", "alfa", "hrdina", "citron", "fiit", "telka"));
        values.forEach(x -> tree.insert(new Node(x,"string432")));
    }
}
