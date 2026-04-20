package com.tictactoe.uc;

import java.util.Scanner;

public class UC3ReadUserSlot {
    public static int readSlot(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        int slot = readSlot(scanner);
        System.out.println("You entered: " + slot);
    }
}
