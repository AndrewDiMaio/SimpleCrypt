package src;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.*;

public class ROT13  {
    char[] tester = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] p1 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] p2 = "nopqrstuvwxyzabcdefghijklm".toCharArray();


    ROT13(Character cs, Character cf) {
        char[] temp1 = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i<temp1.length; i++) {
            if (temp1[i] == cs) {
                p1[i] = cf;
            } else {
                p1[i] = temp1[i];
            }
        }
    }

    ROT13() {

    }


    public String crypt(String text) throws UnsupportedOperationException {

        return text;
    }

    public String encrypt(String text) {
        StringBuilder encrypt = new StringBuilder();
        text = text.toLowerCase();
        char[] test = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int count = 0;
            if (!isAlphabetic(test[i])){
                encrypt.append(test[i]);
            }else {
                while (test[i] != tester[count]) {
                    count++;
                }
                if (count >= 13) {
                    if (i == 0) {
                        encrypt.append(Character.toUpperCase(p2[count]));
                    } else {
                        encrypt.append(p2[count]);
                    }
                } else if (count <= 12) {
                    if (i == 0) {
                        encrypt.append(Character.toUpperCase(p1[count + 13]));
                    } else {
                        encrypt.append(p1[count + 13]);
                    }
                } else {
                    encrypt.append(test[i]);
                }
            }
        }return encrypt.toString();
    }

    public String decrypt(String text) {
        return encrypt(text);
    }

    public static String rotate(String s, Character c) {
        StringBuilder temp = new StringBuilder();
        StringBuilder rotated = new StringBuilder();
        int i = 0;
        while (s.charAt(i) != c){
            temp.append(s.charAt(i));
            i++;
        }while (i<s.length()){
            rotated.append(s.charAt(i));
            i++;
        }


        return rotated.append(temp).toString();
    }

}
