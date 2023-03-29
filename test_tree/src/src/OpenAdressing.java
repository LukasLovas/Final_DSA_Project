package src;

public class OpenAdressing{

    int tableCapacity;
    int tableSize;

    NodeOpenAdressing[] table;

    NodeOpenAdressing tempNode;

    public OpenAdressing(int size){
        this.tableCapacity = size;
        this.tableSize = 0;
        this.table = new NodeOpenAdressing[this.tableCapacity];
        this.tempNode = new NodeOpenAdressing("-1","-1");
    }

    public int toPowerOf(int x, int y){
        if (y == 0){
            return 1;
        }
        for (int i = 0; i < y; i++) {
            x*=x;
        }
        return x;
    }

    int hash(String key){

        int sumOfCharValues = 0;
        int i = 0;

        for(char c:key.toCharArray()){
            sumOfCharValues +=((int) c);
            sumOfCharValues *=toPowerOf(7,i);
            sumOfCharValues = sumOfCharValues % this.tableCapacity;
            i++;

            if(sumOfCharValues <= 0){
                sumOfCharValues = sumOfCharValues + this.tableCapacity;
            }
        }

        return sumOfCharValues%this.tableCapacity;
    }

    public void insertNode(String key, String value){
        NodeOpenAdressing temp = new NodeOpenAdressing(key,value);
        int hash = hash(key);
        int index = hash;
        int i = 0;
        while(this.table[index] != null && this.table[index].key != key && (!this.table[index].key.equals("-1"))){
            index = (hash(key)+ i*i)%tableSize;
            i++;
        }
        if (this.table[index] == null || this.table[index].key.equals("-1")) {
            this.tableSize++;
        }
        this.table[index] = temp;

        if ((double)this.tableSize / this.tableCapacity > 0.7) {
            System.out.println("\nResizing - " + this.tableSize + "/" + this.tableCapacity);
            resizeTable();
        }
    }

    public void resizeTable() {
        int newTableCapacity = this.tableCapacity * 2;
        NodeOpenAdressing[] newTable = new NodeOpenAdressing[newTableCapacity];
        for (int i = 0; i < this.table.length; i++) {
            NodeOpenAdressing node = this.table[i];
            if (node != null && !node.key.equals("-1")) {
                int hash = hash(node.key);
                int index = hash;
                int j = 0;
                while(newTable[index] != null){
                    index = (hash + j*j)%newTableCapacity;
                    j++;
                }
                newTable[index] = node;
            }
        }
        this.tableCapacity = newTableCapacity;
        this.table = newTable;
    }

    public void deleteNode(String key){
        int hash = hash(key);
        int index = hash;
        int i = 0;
        while(this.table[index] != null){
            if(this.table[index].key == key){
                NodeOpenAdressing temp = this.table[index];
                this.table[index] = this.tempNode;
                this.tableSize--;
            }
            index = (hash + i*i)%tableSize;
            i++;
        }
    }

    public boolean searchNode(String key){
        int hash = hash(key);
        int index = hash;
        int loopEnd = 0;
        int i = 0;

        while(this.table[index] != null){
            if(loopEnd > this.tableCapacity){
                //System.out.println("presiahnuta kapacita tabulky");
                return false;
            }
            if(this.table[index].key.equals(key)){
               // System.out.printf("Prvok s klucom %s bol sa nachadza v tabulke", key);
                return true;
            }
            index = (hash + i*i)%tableSize;
            i++;
            loopEnd++;
        }
        //System.out.println("Nenachadza sa");
        return false;
    }


    public int getTableSize(){
        return this.tableSize;
    }


    public void printTable(){
        for(int i = 0;i < this.tableCapacity;i++){
            if((this.table[i] != null) && (!this.table[i].key.equals("-1"))){
                System.out.println("index = " + i + ", key = " + this.table[i].key + ", value = " + this.table[i].value);
            }
        }
    }
}
