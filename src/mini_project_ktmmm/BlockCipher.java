/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_project_ktmmm;

import java.util.ArrayList;

/**
 *
 * @author mamadou
 */
public class BlockCipher {
     public static char caracts[] = { '@', '$', '.', '-', '_', '#', '&' };

    public static int getByte() {
        return (int) (Math.random() * 2);
    }
    
     public ArrayList<String> stringToBinary(String text) {
        char[] tab = text.toCharArray();
        ArrayList<String> myTab = new ArrayList<String>();
        String f = "";
        for (char c : tab) {
            f = Integer.toBinaryString(c);
            if (Character.isDigit(c)) {
                myTab.add("0" + f);
            } else {
                myTab.add(f);
            }
        }
        return myTab;
    }
     
      public ArrayList<String> getKey(int index) {
        String key = "";
        ArrayList<String> getKeyTab = new ArrayList<String>();
        ArrayList<String> tab = new ArrayList<String>();
        for (int i = 0; i < index; i++) {
            key += String.valueOf(getByte());
        }
        getKeyTab.add(key);
        int count = 0;
        String newString = "";
        char[] tabEssai = getKeyTab.get(0).toCharArray();
        for (char c : tabEssai) {
            newString += c;
            count += 1;
            if (count % 7 == 0) {
                tab.add(newString);
                newString = "";
            }
        }
        return tab;
    }
 
     public ArrayList<String> cipherText(ArrayList<String> initialCode, ArrayList<String> key) {
        ArrayList<String> cipher = new ArrayList<String>();
        int sum = 0;
        char[] tab1 = {};
        char[] tab2 = {};
        for (int i = 0; i < initialCode.size(); i++) {
            String cipherCode = "";
            tab1 = initialCode.get(i).toCharArray();
            tab2 = key.get(i).toCharArray();
            for (int j = 0; j < tab2.length; j++) {
                sum = Character.getNumericValue(tab1[j]) + Character.getNumericValue(tab2[j]);
                if (sum == 2) {
                    sum = sum % 2;
                }
                cipherCode += String.valueOf(sum);
            }
            cipher.add(cipherCode);
            cipherCode = "";

        }
        return cipher;
    }  
     
        public ArrayList<String> decryptText(ArrayList<String> cipherText, ArrayList<String> key) {
        ArrayList<String> decrypt = new ArrayList<String>();
        int sum = 0;
        char[] tab1 = {};
        char[] tab2 = {};
        for (int i = 0; i < cipherText.size(); i++) {
            String decryptCode = "";
            tab1 = cipherText.get(i).toCharArray();
            tab2 = key.get(i).toCharArray();
            for (int j = 0; j < tab2.length; j++) {
                sum = Character.getNumericValue(tab1[j]) + Character.getNumericValue(tab2[j]);
                if (sum == 2) {
                    sum = sum % 2;
                }
                decryptCode += String.valueOf(sum);
            }
            decrypt.add(decryptCode);
            decryptCode = "";

        }
        return decrypt;
    } 
}
