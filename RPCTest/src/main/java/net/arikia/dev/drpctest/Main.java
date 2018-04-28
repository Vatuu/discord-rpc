package net.arikia.dev.drpctest;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static boolean ready = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Derp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("In Discord, set your active game to: \"Derp\"");
        frame.getContentPane().add(text, SwingConstants.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down DiscordHook.");
            DiscordRPC.discordShutdown();
        }));

        initDiscord();

        int score = 0;
        System.out.println("Running callbacks...");

        while (true) {
            DiscordRPC.discordRunCallbacks();

            if(!ready)
                continue;

            System.out.print("> ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (!input.equalsIgnoreCase("shutdown")) {
                if (input.equalsIgnoreCase("test")) {
                    System.out.println("Test.");
                    score++;
                    DiscordRichPresence rich = new DiscordRichPresence();
                    rich.state = "Running Test | Private";
                    rich.details = "Score = " + score;
                    DiscordRPC.discordUpdatePresence(rich);
                } else if (input.equalsIgnoreCase("dejay")) {
                    System.out.println("DeJay has a severe case of the gays, I'm afraid.");
                } else {
                    System.out.println("Unknown Command!");
                }
            } else {
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
