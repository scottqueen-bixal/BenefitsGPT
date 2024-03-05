package org.mfusco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BenefitChat benefitChat = new BenefitChat(args[0]);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("> ");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println( benefitChat.chat(line) );
                System.out.print("> ");
            }
        }
    }
}
