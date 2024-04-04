/* 

Q4:Write a Java Program to find the duplicate characters in a string.

*/


import java.util.HashMap;

public class FindDuplicate {

    public static void findDuplicates(String str){
        str=str.toLowerCase();   // Just to check all characters of string even they are uppercase or lowercase.
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        
        for (char ch : charArray) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        System.out.println("Duplicate characters in the string '" + str + "':");
        map.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(key + ": " + value + " times");
            }
        });
    }
    public static void main(String args[]){
        String str = "ParthKulkarni";
        findDuplicates(str);
    }
}
