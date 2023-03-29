
public class Main {
    public static void main(String[] args)
    {
        SeparateChaining hashTable = new SeparateChaining(10);
        hashTable.insertNode("this", "1");
        hashTable.insertNode("coder", "2");
        hashTable.insertNode("this", "4");
        hashTable.insertNode("hi", "5");
        System.out.printf("Nasiel som: %s\n",hashTable.searchNode("coder"));
        System.out.printf("Velkost tabulky je: %d\n",hashTable.getArrayCapacity());
        System.out.printf("Tabulka je naplnena na %.2f%%\n",((float)hashTable.getArraySize()/ (float)hashTable.getArrayCapacity())*100);
        System.out.printf("Vymazal som: %s\n",hashTable.deleteNode("hi"));
        System.out.printf("Vymazal som: %s\n",hashTable.deleteNode("this"));
        System.out.printf("Tabulka je naplnena na %.2f%%\n",((float)hashTable.getArraySize()/ (float)hashTable.getArrayCapacity())*100);
//        System.out.println(hashTable.getArraySize());
//        System.out.println(hashTable.checkEmpty());
    }
}

