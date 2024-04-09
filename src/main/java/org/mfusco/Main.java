package org.mfusco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BenefitChat benefitChat = new BenefitChat(args[0]);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\r\nHow can I help you today? > ");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("\r\n" + benefitChat.chat(line) +"");
                System.out.print("\r\n> ");
            }
        }
    }
}
