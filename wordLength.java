/* Q3:Write a Java Program to count the number of words in a string using HashMap.
*/

import java.util.HashMap;
public class wordLength {
    public static int getCount(String str){
        
        HashMap<String,Integer> map = new HashMap<>();
        String arr[]=str.split(" ");   //If we just want the count of total wors we can also return the length of this array
                                             // but the question requires use of hashmap, so for that here is the implementation using hashmap.
        
        
        for(int i=0;i<arr.length;i++){
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i],count+1);
        }

        System.out.println("The count of unique words in the string is "+ map.size());
        int totalCount = 0;
        for (int count : map.values()) {
            totalCount += count;
        }
        return totalCount;
    }
    public static void main(String args[]){
        String str = "I am perfect candidate to join winsoft technologies beacuse I am good at java";
        int count= getCount(str);
        System.out.println("Count of total words in the string is "+ count);
    }
}
