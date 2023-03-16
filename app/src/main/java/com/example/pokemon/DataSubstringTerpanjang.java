package com.example.pokemon;


import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataSubstringTerpanjang {
    public static void main(String[] args) throws IOException {
        int maxLength = 0;
        String longestSubstring = "";

        Scanner keyboard = new Scanner(System.in);
        System.out.println("### Program Substring Terpanjang Tidak Berulang ###");
        System.out.print("Masukkan Kata : ");
        String str = keyboard.nextLine();

        for (int i = 0; i < str.length(); i++) {
            Set set = new HashSet<>();
            StringBuilder substr = new StringBuilder();

            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
                substr.append(c);
            }

            if (substr.length() > maxLength) {
                maxLength = substr.length();
                longestSubstring = substr.toString();
            }
        }

        System.out.println("Substring terpanjang adalah : " + longestSubstring);
        System.out.println("Panjang Karankter : " + longestSubstring.length());
    }
}
