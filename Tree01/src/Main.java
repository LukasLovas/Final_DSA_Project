import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(new Node(9,"string"));
        //tree.insert(new NodeString("nieco"));

        insertValues(tree);
        //tree.print();

        tree.searchNode(17);
        //tree.print();

        tree.deleteNode(17);
        //tree.print();
        tree.searchNode(17);
        tree.print();

    }

    public static void insertValues(Tree tree){
        List<Integer> values = new ArrayList<>(Arrays.asList(10,15,1,5,2,3,75,4,17,20,6));
        //List<String> stringValues = new ArrayList<>(Arrays.asList("ahoj", "jablko", "zero", "alfa", "hrdina", "citron", "fiit", "telka"));
        values.forEach(x -> tree.insert(new Node(x,"string432")));
        //stringValues.forEach(x -> tree.insert(new NodeString(x)));
    }
}
