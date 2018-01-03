import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

import javax.swing.*;
import java.util.Scanner;

public class Main{

    public static boolean ready = false;

    public static void main(String[] args){

        Window w = new Window();

        boolean running = true;

        int score = 0;

        initDiscord();

        while(running){
            DiscordRPC.DiscordRunCallbacks();

            if(!ready)
                continue;

            String input = getInput();

            if(input.equalsIgnoreCase("test")){
                System.out.println("Test.");
                score++;
            }else if(input.equals("shutdown")){
                running = false;
            }else{
                System.out.println("Unknown Command.");
            }
            DiscordRichPresence rich = new DiscordRichPresence();
            rich.state = "Running Test | Private";
            rich.details = "Score = " + score;
            DiscordRPC.DiscordUpdatePresence(rich);
            ready = true;
        }

        DiscordRPC.DiscordShutdown();
        w.dispose();
    }

    static class Window extends JFrame{
        Window(){
            super("Derp");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(0, 0);
            setVisible(true);
        }
    }

    private static String getInput() {
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input.toLowerCase();
        return input;
    }

    private static void initDiscord(){
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = new Ready();
        DiscordRPC.DiscordInitialize("378728924143812609", handlers, true);
    }

    private static class Ready implements ReadyCallback{
        public void apply(){
            System.out.println("Ready.");
            DiscordRichPresence rich = new DiscordRichPresence();
            rich.state = "Running Test | Private";
            rich.details = "Score = 0";
            DiscordRPC.DiscordUpdatePresence(rich);
            ready = true;
        }
    }
}
