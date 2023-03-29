package src;

import java.util.ArrayList;
import java.util.Iterator;

public class SeparateChaining {
    ArrayList<NodeSeparateChaining> chainArray;
    int arrayCapacity;
    int arraySize;

    public SeparateChaining(int size) {
        this.chainArray = new ArrayList<>();
        this.arrayCapacity = size;
        this.arraySize = 0;

        for (int i = 0; i < arrayCapacity; i++) {
            chainArray.add(null);
        }
    }

    public int getArrayCapacity() {return arrayCapacity;}
    public int getArraySize(){return arraySize;}

    public int toPowerOf(int x, int  y){
        if(y == 0){
            return 1;
        }
        for(int i = 1;i <= y;i++){
            x*=x;
        }
        return x;
    }

    int hash(String key){

        int sumOfCharValues = 0;
        int i = 0;

        for(char c:key.toCharArray()){
            sumOfCharValues +=((int) c);
            sumOfCharValues *=toPowerOf(13,i);
            sumOfCharValues = sumOfCharValues % this.arrayCapacity;
            i++;

            if(sumOfCharValues <= 0){
                sumOfCharValues = sumOfCharValues + this.arrayCapacity;
            }
        }

        return sumOfCharValues%this.arrayCapacity;
    }

    public String deleteNode(String key){
        int index = hash(key);
        NodeSeparateChaining current = chainArray.get(index);
        NodeSeparateChaining last = null;
        while(current != null){
            if(current.key.equals(key)){
                break;
            }
            last = current;
            current = current.next;
        }
        if(current == null){
            return null;
        }
        arraySize--;
        if(last != null){
            last.next = current.next;
        }
        else{
            chainArray.set(index,current.next);
        }
        return current.value;
    }

    public String searchNode(String key){
        int index = hash(key);
        NodeSeparateChaining current = chainArray.get(index);
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void printTable() {
        for (int i = 0; i < arrayCapacity; i++) {
            NodeSeparateChaining current = chainArray.get(i);
            System.out.print("Index " + i + ": ");
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ")");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void insertNode(String key, String value){
        int index = hash(key);
        NodeSeparateChaining current = chainArray.get(index);
        while(current != null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        arraySize++;
        current = chainArray.get(index);
        NodeSeparateChaining createdNode = new NodeSeparateChaining(key,value);
        createdNode.next = current;
        chainArray.set(index, createdNode);

        if(((1.0 * arraySize) / arrayCapacity) >= 0.7){ //upsizing and rehashing
            ArrayList<NodeSeparateChaining> temp = chainArray;
            chainArray = new ArrayList<>();
            arrayCapacity = 2*arrayCapacity;
            arraySize = 0;

            for (int i = 0; i < arrayCapacity; i++) {
                chainArray.add(null);
            }


            for(NodeSeparateChaining node : temp) {
                while (node != null) {
                    insertNode(node.key,node.value);
                    node = node.next;
                }
            }
        }
        
    }
}


