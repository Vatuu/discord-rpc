package net.arikia.dev.drpctest;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        initDiscord();

        JFrame frame = new JFrame("Derp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("In Discord, set your active game to: \"Derp\"");
        frame.getContentPane().add(text, SwingConstants.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        int score = 0;

        while (true) {
            System.out.println("discordRunCallbacks...");
            DiscordRPC.discordRunCallbacks();
            System.out.println("discordRunCallbacks - Success");

            System.out.println("getInput...");
            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            System.out.println("getInput - Success");

            if (!input.equalsIgnoreCase("shutdown")) {
                if (input.equalsIgnoreCase("test")) {
                    System.out.println("Test.");
                    score++;
                    DiscordRichPresence rich = new DiscordRichPresence();
                    rich.state = "Running Test | Private";
                    rich.details = "Score = " + score;
                    DiscordRPC.discordUpdatePresence(rich);
                } else {
                    System.out.println("Unknown Command!");
                }
            } else {
                // lol.
                DiscordRPC.discordShutdown();
                frame.dispose();
                System.exit(0);
            }
        }
    }

    private static void initDiscord() {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = new Ready();
        DiscordRPC.discordInitialize("415885161457123338", handlers, true);
    }

}
