/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_project_ktmmm;

import java.util.ArrayList;

/**
 *
 * @author M.WONE
 */
import java.util.*;

public class Cipher {
    String utils [] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9"};


    public static int genNumber(){
        return  (int) Math.round(Math.random() * (36));
    }

    public static boolean isPremier(int number){
        boolean premier = true;
        for (int i = 2; i < number ; i++) {
            if (number % i == 0){
                premier = false;
                break;
            }
        }
        return premier;
    }

    public static ArrayList<Integer> getKey(){
//        L'equation est de la forme y = ax + b
        ArrayList<Integer> key = new ArrayList<Integer>();
        int a = genNumber();
        int b = genNumber();
        boolean start = true;
        while (start){
            if (a == b || !isPremier(a) || !isPremier(b) || a == 0 || b == 0) {
                a = genNumber();
                b = genNumber();
            }else {
                key.add(a);
                key.add(b);
                start = false;
            }
        }
        return key;
    }

    public ArrayList<String> toList(String initialCode) {
        char[] letters_list = initialCode.toCharArray();
        String letters = "";
        ArrayList<String> CodeList = new ArrayList<String>();
        for(char letter: letters_list){
            letters += letter;
            CodeList.add(String.valueOf(letter).toLowerCase());
        }
        return CodeList;
    }

    public ArrayList<Integer> getIndex(ArrayList<String> list){
        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for(String letter: utils){
            letters.add(letter);
        }
        for(String item: list){
            indexList.add(letters.indexOf(item));
        }
        return indexList;
    }

    public String cipherCode(ArrayList<Integer> indexList, ArrayList<Integer> key){
        String cipherText = "";
        ArrayList<Integer> test = new ArrayList<Integer>();
        int a = key.get(0);
        int b = key.get(1);
        int y;
        for(Integer item: indexList){
            y = a * item + b;
            if (y >= 36){
                y = y % 36;
            }
            test.add(y);
            cipherText += utils[y];
        }
        return cipherText;
//        System.out.println(test);
//        System.out.println(cipher);
    }


}
