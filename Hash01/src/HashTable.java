import java.lang.String;


public class HashTable{
    int SumOfChars = 0;
    int hash(String key){
        for(int i = 0; i < key.length();i++){
            char[] array = key.toCharArray();
            SumOfChars = ((int)array[i]) + SumOfChars;
            SumOfChars = SumOfChars*(33*i);
            SumOfChars = SumOfChars%//TableSize

        }
    }
}
