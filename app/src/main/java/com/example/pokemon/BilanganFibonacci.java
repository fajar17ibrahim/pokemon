package com.example.pokemon;

import java.io.IOException;
import java.util.Scanner;

public class BilanganFibonacci {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("### Program Bilangan Fibonacci ###");
        System.out.print("Masukkan jumlah bilangan Fibonacci: ");
        int n = Integer.parseInt(keyboard.nextLine());

        int bil1 = 0;
        int bil2 = 1;
        int bil3 = 0;
        String result = "0 1 ";
        for (int i = 0; i < n - 2; i++) {
            bil3 = bil1 + bil2;
            bil1 = bil2;
            bil2 = bil3;

            result += bil3 + " ";
        }

        System.out.println(result);
    }
}
