package src;


import java.util.Random;

public class MainTest {


    static int randomKey(Random k) {
        int key = k.nextInt(1000);
        return key;
    }

    static String randomValue(Random v) {
        String value = "";

        for (int j = 0; j < 7; j++) {
            char c = (char) (97 + (int) (v.nextFloat() * (122 - 98)));
            value += c;
        }
        return value;
    }

    public static void testTreeAVL(Random k, Random v) {
        int i = 10_000;
        System.out.printf("%10s\t%10s\t%10s\t%10s\n", "Test Case", "AVLTree Insert", "AVLTree Search", "AVLTree Delete");
        while (i < 1_000_000) {
            TreeAVL tree = new TreeAVL();


            for (int j = 0; j < i; j++) {
                tree.insert(new NodeAVL(randomKey(k), randomValue(v)));
            }

            double startInsert = System.nanoTime();
            tree.insert(new NodeAVL(randomKey(k), randomValue(v)));
            double endInsert = System.nanoTime() - startInsert;

            //tree.print();
            //System.out.println();

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                tree.searchNode(randomKey(k));
            }

            double startSearch = System.nanoTime();
            tree.searchNode(randomKey(k));
            double endSearch = System.nanoTime() - startSearch;

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                tree.deleteNode(randomKey(k));
            }

            double startDelete = System.nanoTime();
            tree.deleteNode(randomKey(k));
            double endDelete = System.nanoTime() - startDelete;
            //System.out.println();

            //tree.print();

            System.out.printf("%n%20s\t%10s\t%10s\t%10s", i + "", endInsert + "", endSearch + "", endDelete + "");

            i += 10_000;
        }

    }


    public static void testTreeSplay(Random k, Random v) {
        int i = 10_000;
        System.out.printf("%10s\t%10s\t%10s\t%10s\n", "Test Case", "SplayTree Insert", "SplayTree Search", "SplayTree Delete");
        while (i < 1_000_000) {
            TreeSplay tree = new TreeSplay();


            for (int j = 0; j < i; j++) {
                tree.insert(new NodeSplay(randomKey(k), randomValue(v)));
            }

            double startInsert = System.nanoTime();
            tree.insert(new NodeSplay(randomKey(k), randomValue(v)));
            double endInsert = System.nanoTime() - startInsert;

            //tree.print();
            //System.out.println();

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                tree.search(randomKey(k));
            }

            double startSearch = System.nanoTime();
            tree.search(randomKey(k));
            double endSearch = System.nanoTime() - startSearch;

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                tree.deleteNode(randomKey(k));
            }

            double startDelete = System.nanoTime();
            tree.deleteNode(randomKey(k));
            double endDelete = System.nanoTime() - startDelete;
            //System.out.println();

            //tree.print();

            System.out.printf("%n%20s\t%10s\t%10s\t%10s", i + "", endInsert + "", endSearch + "", endDelete + "");

            i += 10_000;
        }
    }

    public static void testSeparateChaining(Random k, Random v) {
        int i = 10_000;
        System.out.printf("%10s\t%10s\t%10s\t%10s\n", "Test Case", "SeparateChaining Insert", "SeparateChaining Search", "SeparateChaining Delete");
        while (i < 1_000_000) {
            SeparateChaining hashtable = new SeparateChaining(30000);


            for (int j = 0; j < i; j++) {
                hashtable.insertNode(randomValue(k), randomValue(v));
            }

            double startInsert = System.nanoTime();
            hashtable.insertNode(randomValue(k), randomValue(v));
            double endInsert = System.nanoTime() - startInsert;

            //tree.print();
            //System.out.println();

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                hashtable.searchNode(randomValue(k));
            }

            double startSearch = System.nanoTime();
            hashtable.searchNode(randomValue(k));
            double endSearch = System.nanoTime() - startSearch;

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                hashtable.deleteNode(randomValue(k));
            }

            double startDelete = System.nanoTime();
            hashtable.deleteNode(randomValue(k));
            double endDelete = System.nanoTime() - startDelete;
            //System.out.println();

            //tree.print();

            System.out.printf("%n%20s\t%10s\t%10s\t%10s", i + "", endInsert + "", endSearch + "", endDelete + "");
            i += 10_000;
        }
        SeparateChaining hashtable = new SeparateChaining(i);
        for (int j = 0; j < i; j++) {
            hashtable.insertNode(randomValue(k), randomValue(v));
        }
        hashtable.printTable();
    }




    public static void testOpenAdressing(Random k, Random v) {
        int i = 10_000;
        System.out.printf("%10s\t%10s\t%10s\t%10s\n", "Test Case", "OpenAdressing Insert", "OpenAdressing Search", "OpenAdressing Delete");
        while (i < 500_000) {
            OpenAdressing hashtable = new OpenAdressing(500_000);


            for (int j = 0; j < i; j++) {
                hashtable.insertNode(randomValue(k), randomValue(v));
            }

            double startInsert = System.nanoTime();
            hashtable.insertNode(randomValue(k), randomValue(v));
            double endInsert = System.nanoTime() - startInsert;

            //tree.print();
            //System.out.println();

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                hashtable.searchNode(randomValue(k));
            }

            double startSearch = System.nanoTime();
            hashtable.searchNode(randomValue(k));
            double endSearch = System.nanoTime() - startSearch;

            k = new Random(300);
            v = new Random(300);

            for (int j = 0; j < i; j++) {
                hashtable.deleteNode(randomValue(k));
            }

            double startDelete = System.nanoTime();
            hashtable.deleteNode(randomValue(k));
            double endDelete = System.nanoTime() - startDelete;
            //System.out.println();

            //tree.print();

            System.out.printf("%n%20s\t%10s\t%10s\t%10s", i + "", endInsert + "", endSearch + "", endDelete + "");
            i += 10_000;
        }
        OpenAdressing hashtable = new OpenAdressing(i);
        for (int j = 0; j < i; j++) {
            hashtable.insertNode(randomValue(k), randomValue(v));
        }
        hashtable.printTable();
    }


    public static void main(String[] args) {
        Random k = new Random(300);
        Random v = new Random(300);

        //testTreeAVL(k, v);
        //testTreeSplay(k,v);
        //testSeparateChaining(k,v);
        testOpenAdressing(k,v);
    }
}

