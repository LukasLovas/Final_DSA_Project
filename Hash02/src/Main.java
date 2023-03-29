public class Main {
    public static void main(String[] args) {
        OpenAdressing hashTable = new OpenAdressing();
        hashTable.insertNode("4","hlupacik");
        hashTable.insertNode("2","mackopes");
        hashTable.insertNode("5","abrakadabra");
        hashTable.printTable();
        System.out.println(hashTable.getTableSize());
        System.out.println(hashTable.deleteNode("4"));
        System.out.println(hashTable.getTableSize());
        System.out.println(hashTable.searchNode("5"));
        System.out.println(hashTable.searchNode("8"));
    }
}