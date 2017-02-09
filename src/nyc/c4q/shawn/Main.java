package nyc.c4q.shawn;

import java.util.HashMap;
import java.util.jar.Pack200;

public class Main {

    public static void main(String[] args) {
	// write your code here


//        System.out.println(wordToArray("HELP MEL"));

//        System.out.println(truncate("bananas", 2));

//        System.out.println(uniqueChars("whoms"));

//        System.out.println(unique2("whomszxcv"));

//        System.out.println(truncate2("Hello, world!"));

//        System.out.println(xToY(4,8));

//        String[] a1 = {"arya", "sansa", "bran"};
//        String[] a2 = {"Daenerys", "tyrion", "jon"};
//
//        System.out.println(combineArrays(a1, a2));

//        System.out.println(isRotated("waterbottle","erbottlewat" ));

//        decode("00011110011");

//        System.out.println(sumOfDigits(12));

//        System.out.println(reverseWords("5 4 3 2 1"));

//        System.out.println(xIsh("unfriendly", "elf" ));

    }


    private static char[] wordToArray(String word){
        return word.toCharArray();
    }

    private static String truncate(String input, int truncateBy){
        if (input.length() < truncateBy){
            return input;
        }
        return input.substring(0,truncateBy) + "...";
    }

    private static boolean uniqueChars(String input){
        String temp = "";
        for(int i = 0; i < input.length(); i++){
            if(temp.contains(String.valueOf(input.charAt(i)))){
                return false;
            }
            temp += input.charAt(i) + "";
        }
        return true;
    }

    private static boolean unique2(String input){
        HashMap<String, Integer> myMap = new HashMap<>();
        for(int i = 0; i < input.length(); i++){
            if(myMap.containsKey(input.charAt(i) +"")){
                return false;
            }
            myMap.put(input.charAt(i)+"", 0);
        }
        return true;
    }

    private static String truncate2(String input){
        if(input.length() > 6){
            return input.substring(0, 3)+ "..." +input.charAt(input.length()-1);
        }
        return input;
    }

    private static int xToY(int x, int y){
        int answer = 0;
        while(x <= y){
            answer += x;
            x++;
        }
        return answer;
    }

    private static String[] combineArrays(String[] arr1, String[] arr2){
        String[] answer = new String[arr1.length+arr2.length];
        int idx = 0;
        for(String s: arr1){
            answer[idx] = s;
            idx++;
        }
        for(String s: arr2){
            answer[idx] = s;
            idx++;
        }

        for(String s: answer){
            System.out.println(s);
        }
        return answer;
    }


    private static boolean isRotated(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0; i <= s2.length(); i++){
            s2 = s2.charAt(s2.length()-1) + s2.substring(0, s2.length()-1);
            if(s1.equals(s2)){
                return true;
            }
        }
        return false;
    }


    private static int[] decode(String input){
        int changes = 0;
        char previousChar = '$';

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != previousChar){
                changes++;
            }
            previousChar = input.charAt(i);
        }
        int[] answer = new int[changes];

        while(changes != 0) {
            int insert = 1;
            while (input.length() > 1 && input.charAt(0) == input.charAt(1)) {
                    input = input.substring(1);
                    insert++;

        }
            input = input.substring(1);
            answer[answer.length-changes] = insert;
            changes--;
        }
        for(int i: answer){
            System.out.println(i);
        }
        return answer;
    }

    private static int sumOfDigits(int x){
        x = Math.abs(x);
        if(x < 10){
            return x;
        }
        String temp = String.valueOf(x);
        int first = Integer.valueOf(temp.substring(0,1));
        int rest = Integer.valueOf(temp.substring(1));
        return first + sumOfDigits(rest);
    }

    private static String reverseWords(String input){
        int lastIdxOfSpace = input.lastIndexOf(' ');
        if(lastIdxOfSpace > 0) {
            return input.substring(lastIdxOfSpace + 1) + " " + reverseWords(input.substring(0, lastIdxOfSpace));
        }
        return input;
    }

    private static boolean xIsh(String first, String second){
        if(first.isEmpty()){
            return false;
        }

        char firstChar = first.charAt(0);
        for(int i = 0; i < second.length(); i++){
            if(second.charAt(i) == firstChar){
                second = second.replace(second.charAt(i)+"", "");
            }
        }
        if(second.isEmpty()){
            return true;
        }
        first = first.substring(1);
        return xIsh(first, second);
    }


}
