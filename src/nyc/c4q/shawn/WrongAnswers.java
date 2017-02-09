package nyc.c4q.shawn;

import java.util.HashMap;

/**
 * Created by shawnspeaks on 2/9/17.
 */
public class WrongAnswers {

    public static void main(String[] args) {

    }

    private static boolean isRotated(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = stringToHashMap(s1);
        HashMap<Character, Integer> map2 = stringToHashMap(s2);

        for(Character c: map1.keySet()){
            if(!map1.get(c).equals(map2.get(c))){
                return false;
            }
        }
        for(Character c: map1.keySet()){
            if(!map2.containsKey(c)){
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> stringToHashMap(String input){
        HashMap<Character, Integer> myMap = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            Character currentChar = input.charAt(i);
            if(myMap.containsKey(currentChar)){
                myMap.put(currentChar, myMap.get(currentChar)+1);
            }else
                myMap.put(currentChar, 1);
        }
        return myMap;
    }
}
