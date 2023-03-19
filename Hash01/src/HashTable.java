import java.lang.String;


public class HashTable{
    int sumOfChars = 0;
    int hash(String key){
        char[] array = key.toCharArray();
        for(int i = 0; i < key.length();i++){
            sumOfChars = ((int)array[i]) + sumOfChars;
            sumOfChars = sumOfChars *(33*i);
            sumOfChars = sumOfChars %//TableSize

        }
    }
}
